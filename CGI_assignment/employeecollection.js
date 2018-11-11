var EmployeeCollection = function() {
    this.employees = [];
};

EmployeeCollection.prototype.fetchUsers = function(success, error) {
    var self = this;
    console.log("fetchusers alku");
    UserApi.get(
	function(data) {
	    for (var i = 0;i < data.users.length;i++) {
		self.currentUser = data.users[i];
		self.doUser();
	    }

	    var employees = [];
	    var isEmployee = false;

	    for (var i = 0;i < self.employees.length;i++) {
	        console.log("For self employees");
	        if (self.employees[i].group == "worker" &&
            self.employees[i].group=="director"){
			isEmployee = true;
			employees.push({
			    id  :  self.employees[i].id,
			    name:  self.employees[i].name,
                group: self.employees[i].group
			});
		}
	    }

	    self.employees = employees;

	    success();
	    console.log("fetchusers success");
	},

	function() {
    console.log("Error fetching users");
	}
    );
};


EmployeeCollection.prototype.getEmployees = function() {
    if (this.employees.length > 0) {
	return this.employees;
    } else {
	return [];
    }
};


EmployeeCollection.prototype.getEmployee = function(id) {
    var isFound=false;
    this.currentUser = null;

    for (var i = 0;i < this.employees.length;i++) {
	if (this.employees[i].id == id) {
	    isFound = true;
	    this.currentUser = this.employees[i];
	    break;
	}
    }

    if (isFound) {
	return this.currentUser;
    } else {
	return null;
    }
};


EmployeeCollection.prototype.doUser = function() {
    var currentUser = this.currentUser;
    var userModel = {};

    if (currentUser.role == "developer") {
	userModel.id = currentUser.id;
	userModel.name = currentUser.name;
	userModel.group = "worker";
    } else if (currentUser.role == "operator") {
	userModel.id = currentUser.id;
	userModel.name = currentUser.name;
	userModel.group = "worker";
    } else if (currentUser.role == "manager") {
	userModel.id = currentUser.id;
	userModel.name = currentUser.name;
	userModel.group = "director";
    } else if (currentUser.role == "owner") {
	userModel.id = currentUser.id;
	userModel.name = currentUser.name;
	userModel.group = "owner";
    }

    this.employees.push(userModel);
    console.log("douser");
};
