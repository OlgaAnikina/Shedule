<div class="popup-box" id="popup-box-1">
    <div class="close">X</div>
    <div class="top">
        <h2>Input new event:</h2>
    </div>
    <div class="form-group row">
        <label class="col-sm-6 col-form-label">Choose type of event:</label>
        <select id="typevent">
            <option value="consultation">consultation</option>
            <option value="inspection">inspection</option>
            <option value="operation">operation</option>
            <option value="procedur">procedur</option>
        </select>
    </div>
    <div class="form-group row">
        <label class="col-sm-6 col-form-label">Choose a doctor:</label>
        <select id="doctor">
            <#list userList as user>
                <#if user.isNotAdmin()>
                    <#if user.isDoctor()>
                        <option>${user.username}</option>
                    </#if>
                </#if>
            </#list>
        </select>
    </div>
    <div class="form-group row">
        <label class="col-sm-6 col-form-label">Choose patient name :</label>
        <select id="patient">
            <#list userList as user>
                <#if user.isNotAdmin()>
                    <option>${user.username}</option>
                </#if>
            </#list>

        </select>
    </div>
    <button class="btn btn-primary" type="submit">Submit</button>
</div>