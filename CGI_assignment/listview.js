var listTemplate = '\
    <div class="list-header"> \
        <span>Id</span> \
        <span>Name</span> \
        <span>Group</span> \
    </div> \
    <% this.data.forEach(function(employee) { %> \
    <div class="list-row"> \
                <span><%- employee.id %></span> \
            <span><%- employee.name %></span> \
            <span><%- employee.group %></span> \
        </div> \
    <% }) %> \
';

var ListView = function(id) {
    this.element = $(id);
    this.data = null;
    this.template = _.template(listTemplate)

    console.log("listview");
};

ListView.prototype.setData = function(data) {
    this.data = data;
    console.log("setdata");
};

ListView.prototype.render = function() {
    console.log("it should now render the employee list");
    _.each(this.data, function() {
        this.element.html(this.template(this.data));
}.bind(this))
};
