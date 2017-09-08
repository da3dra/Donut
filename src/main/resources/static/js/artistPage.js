$(document).ready(function () {

	var id = getParameterByName('id');
	
	$.ajax({ 
        type: "GET",
        url: "/artist/"+id,
        success: function (data) {
        	//$.each(data.content, function(i, item) {
        		$("#artist_name").text(data.username);
           // })
        },
        error: function (e) {
         alert('error');
        }
});
	$.ajax({ 
        type: "GET",
        url: "/artist/"+id+"/albums",
        success: function (data) {
        	$.each(data, function(i, item) {
        	     var toAppend = "";
        	      toAppend +=  '<div class="span2"><img src="data:image/png;base64,'+item.cover+'" class="thumbnail"/>'+
                    '<h5>'+item.title+'</h5></div>';
        		 $('#artist_albums').append(toAppend);
            })
        },
        error: function (e) {
         alert('get albums error');
        }
	});
	
	function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}
	
});

