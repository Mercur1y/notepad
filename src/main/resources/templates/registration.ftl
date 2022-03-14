<#import "macros/common.ftl" as c>
<#import "macros/login.ftl" as l>

<@c.page>
    <div class="mb-1"><h3>Add new user</h3></div>
    <@l.login "/registration" true />
</@c.page>