package com.mercur1y.servingwebcontent.controller;

import com.mercur1y.servingwebcontent.domain.Note;
import com.mercur1y.servingwebcontent.domain.User;
import com.mercur1y.servingwebcontent.repos.NoteRepo;
import com.mercur1y.servingwebcontent.repos.UserRepo;
import com.mercur1y.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting(
            @AuthenticationPrincipal User user,
            Model model) {

        if(!userService.isAdminAdded()) userService.initDB();

        if (!(user == null))
        {
            Long id = user.getId();
            Optional<User> user1 = userRepo.findById(id);
            int count = user1.get().getNotes().size();
            model.addAttribute("count", count);
        }
        model.addAttribute("user", user);
        return "greeting";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Note note,
            BindingResult bindingResult,
            Model model
    ) {
        Calendar instance = Calendar.getInstance();
        note.setAuthor(user);
        note.setLocalDateTime(instance.getTime());

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("note", note);
        } else {
            noteRepo.save(note);
        }

        return "main";
    }

    @GetMapping("/user-notes/{user}")
    public String userNotes(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            @RequestParam(required = false) Note note,
            Model model
    ) {
        if (!(user == null)) {
            Set<Note> notes = user.getNotes();
            int count = notes.size();
            model.addAttribute("count", count);
            model.addAttribute("notes", notes);
        }
        model.addAttribute("note", note);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userNotes";
    }

    @PostMapping("/user-notes/{userId}")
    public String updateNote(
            @PathVariable Long userId,
            @AuthenticationPrincipal User user,
            @Valid Note note,
            BindingResult bindingResult,
            Model model
            ) {
        Calendar instance = Calendar.getInstance();
        note.setAuthor(user);
        note.setLocalDateTime(instance.getTime());

        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("note", note);
        } else {
            noteRepo.save(note);
        }
        return "redirect:/user-notes/" + userId;
    }
    @GetMapping("/user-notes/delNote/{id}")
    public String deleteNote(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long id
    ) {
        noteRepo.deleteById(id);

        return "redirect:/user-notes/" + currentUser.getId();
    }

}
