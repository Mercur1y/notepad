<#include "security.ftl">
<h4 xmlns="http://www.w3.org/1999/html">Note List</h4>
<div class="card-columns">
    <#list notes as note>
        <div class="card my-3">
                <span>${note.text}</span><br/>
            <div id="button" class="card-footer text-muted">
                <a>${note.localDateTime}</a>
                <#if note.author.id == currentUserId>
                    <a class="btn btn-outline-primary" href="/user-notes/${note.author.id}?note=${note.id}">
                        Edit
                    </a>
                    <a class="btn btn-outline-danger" href="/user-notes/delNote/${note.id}">
                        Delete
                    </a>
                </#if>
            </div>
        </div>
    <#else>
        You don't have any notes
    </#list>
</div>