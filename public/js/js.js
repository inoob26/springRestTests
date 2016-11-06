var id0=1;

function getAllEmployee(){
    $('#tbl').html("");

    $('#tbl').append(
        "<table class='table table-hover' id='employeeDataTable' >" +
        '<tr>' +
            '<th>Id</th>' +
            '<th>Name</th>' +
            '<th>Position</th>' +
        '</tr>' +
        '</table>'
    );

    $.getJSON("/employeeAll",function (data) {
        $.each(data, function (index, employee) {
            $("#employeeDataTable").append("<tr><td>" + employee.id + "</td>"
                + "<td>" + employee.ename + "</td>" + "<td>" + employee.position + "</td></tr>" );

        });
        //add events for TR tag
        $("tr").on("click",function(){
            //remove selected class for all elements
            $("tr").removeClass("active");
            //select only clicked class
            $(this).addClass("active");
            id0 = $(this).children().first().text();
            //add button events

            $("#e_edit").on("click",function(){
                getEmployeeById();
            });
        });
    });


}

function getEmployeeById() {
    $.getJSON('/employee?id=' + id0, function(data) {
        $("#employee_name").val(data[0].ename);
        $("#employee_position").val(data[0].position);
        $("#employee_title").html("<h3>Edit person : \""  + data[0].ename + "\" </h3>" );
    });
}

function sendData() {
    $.ajax({
        url:  "/editEmployee?id=" + id0 + "&name=" + $("#employee_name").val() + "&position=" + $("#employee_position").val() ,
        type: 'GET',
        success: function(){
            $('#tbl').html("");
            $('#editEmployee').modal('hide');
            getAllEmployee();
        },
        fail: function(){
            alert("Something was wrong during edit Employee");
        }
    });


}

function saveEmployeer() {
    $.ajax({
        url:  "/addEmployee?name=" + $("#new_employee_name").val() + "&position=" + $("#new_employee_position").val() ,
        type: 'POST',
        success: function(){
            $("#newEmployee").modal("hide");
            getAllEmployee();
        },
        fail: function(){
            alert("Something was wrong during save Employee");
        }
    });
}

function showDel(){
    $("#delEmployee").modal('show');

    $.getJSON('/employee?id=' + id0, function(data) {
        $("#del_employee_title").html("<h3>Are you sure to delete this employee " + data[0].ename +  "?</h3>" );
    });
}

function deleteEmployee() {
    $.ajax({
        url:  "/deleteEmployee?id=" + id0 ,
        type: 'DELETE',
        success: function(){
            $("#delEmployee").modal('hide');
            getAllEmployee();
        },
        fail: function(){
            alert("Something was wrong during delete Employee");
        }
    });
}