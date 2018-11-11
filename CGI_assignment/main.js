// Initialize application when DOM is ready
$(document).ready(function() {

    console.log("Toimiiko?");

    $("#fetchUsersBtn").click(function() {

        console.log("Entas tama?");

    var employees = new EmployeeCollection();
    var listView = new ListView("#employeeList");

    employees.fetchUsers(
	function() {
	    listView.setData(employees.getEmployees());
	    listView.render()
	    console.log("Luki");
	},

	function() {
	    alert('User data could not be fetched');
	}
    );
});
});
