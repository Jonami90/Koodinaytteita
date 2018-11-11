// DON'T CHANGE THIS FILE

var UserApi = {};

// Simulates GET request to server
UserApi.get = function(successCb, errorCb) {
    successCb(UserApi.data);
};

UserApi.data = { users: [
    {
	id  : 1,
	name: 'Brooklynn Rios',
	role: 'developer'
    },
    {
	id  : 2,
	name: 'Maurice Cortez',
	role: 'developer'
    },
    {
	id  : 3,
	name: 'Eliana Novak',
	role: 'manager'
    },
    {
	id  : 4,
	name: 'Aliana Perry',
	role: 'developer'
    },
    {
	id  : 5,
	name: 'Madelyn Kramer',
	role: 'manager'
    },
    {
	id  : 6,
	name: 'Delilah Goodwin',
	role: 'manager'
    },
    {
	id  : 7,
	name: 'Matt Davidson',
	role: 'developer'
    },
    {
	id  : 8,
	name: 'Amina Morrison',
	role: 'owner'
    },
    {
	id  : 9,
	name: 'Delaney Richard',
	role: 'developer'
    },
    {
	id  : 10,
	name: 'Bruce Walter',
	role: 'operator'
    },
    {
	id  : 11,
	name: 'Gwendolyn Castro',
	role: 'owner'
    },
    {
	id  : 12,
	name: 'Mekhi Wolfe',
	role: 'developer'
    }
]};
