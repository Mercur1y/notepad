<#import "macros/common.ftl" as c>

<@c.page>
    <div class="mx-auto">
    <div class="container-lg" align="center" >
        <h1>Welcome to NotePad</h1>
        <h5>Hello, <#if user??>${user.username}<#else>guest</#if></h5>
        <h5><#if user??>You have ${count} notes<#else></#if></h5>
    </div>
    </div>
</@c.page>