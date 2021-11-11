/**
 * 
 */

var checkSubScriptionUrl = "/v1/subscribe/";
const callAjaxWithJsonPost = async (url,json, callback) => {
	console.log(json)
	$.ajax({
		type: "Post",
		url: url,
		data: JSON.stringify(json),
		headers: {
		    "Content-Type": "application/json"
		},
		success: function(result) {
			callback(result,json);
		}
	});
}

const checkSub = async (ani,service) => {
	var json ={ani,service};
	callAjaxWithJsonPost(checkSubScriptionUrl,json,processSubResponse);
}

const processSubResponse = (data,json) => {
	console.log(data);
	if(data != ''){
		window.location.href = "login/"+data.id;
	}
}


var interval;
const callSubCheck = (ani,service) => {
	let count=1;
	interval= setInterval(() => {	
		if(count==3){
			stopinterval();
		}	
		checkSub(ani,service);
		count++;			
	}, 3000);
}
const stopinterval = () => {
	clearInterval(interval);
}
