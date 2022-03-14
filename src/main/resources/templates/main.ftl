<#import "macros/common.ftl" as c>
<#import "macros/login.ftl" as l>

<@c.page>
    <h4>Add new note</h4>
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input id="text" type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
                       value="<#if note??>${note.text}</#if>" name="text" placeholder="Enter the text..." />
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <#if !textError?? && note??>
                <div class="alert alert-success" role="alert">
                    Note added! You can view it on the page <a href="/user-notes/${note.author.id}">My notes</a>
                </div>
            </#if>
            <div class="form-group">
                <button id="clear" type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</@c.page>