var macMenu = {
	foods : {},

	meals : {},
	
	init: function(callback) {
		OrderMaker.getFoodMenu( function(data) {
			macMenu.foods = data;
			OrderMaker.getMealMenu( function(data) {
				macMenu.meals = data;
				callback(macMenu);
			});
		});
	}
};