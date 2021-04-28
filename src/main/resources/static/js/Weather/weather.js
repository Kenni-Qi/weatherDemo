$(document).ready(function(){ 
	init();
	});
	
function init(){
	//Init cityListJson
	var cityListJson = jQuery.parseJSON($("#cityListJson").val());
	$.each(cityListJson,function(i,obj){
		 $("#citySelect").append("<option value='"+obj+"'>"+obj+"</option>")
	});
}	

function cityChange(cityValue){
				$.ajax({
				       type: "POST",
				       url: encodeURI("getWeatherInfo"),
				       data:{"cityValue":encodeURI(cityValue)},
				       contentType: "application/x-www-form-urlencoded; charset=utf-8",
                       async:true,
				       success: function(result){
                           var data = decodeURIComponent(result);
    	                   var data = data.replace(/\+/g, " ");
    	                   var obj = jQuery.parseJSON(data);
                           $("#updatetime").val(obj.updatetime);
                           $("#updatetime").text(obj.updatetime);
                           $("#weather").val(obj.weather);
                           $("#weather").text(obj.weather);
                           $("#temperature").val(obj.temperature);
                           $("#temperature").text(obj.temperature);
                           $("#wind").val(obj.wind);
                           $("#wind").text(obj.wind);
                           $("#updatetime").attr("disabled","disabled");
                           $("#weather").attr("disabled","disabled");
                           $("#temperature").attr("disabled","disabled");
                           $("#wind").attr("disabled","disabled");
	                   }
			         });
};