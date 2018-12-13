<#import "parts/common.ftl" as c>

<@c.page>
    <div class="user-edit">
    <div class="user-edit-title">User editor</div>
    <div class="user-edit-form">
    <form action="/user" method="post">
        <div class="user-edit-label">Name</div>
        <input type="text" name="username" value="${user.username}">
        <div class="user-edit-label _role">Role</div>
        <div class="list-role">
            <#list roles as role>
                <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#list>
        </div>
        <input type="hidden" value="${user.id}" name="userId">
        <button type="submit" class="btn btn-primary">Save</button>
        </form>
    </div>
    </div>
</@c.page>