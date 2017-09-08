$(document).ready(function () {
	
	var item = getParameterByName('item');
	$.ajax({ 
		type: "GET",
		url: '/search/'+item,
	success: function (data) {
		//alert(JSON.stringify(data))
	 	$.each(data.artists, function(i, item) {
    		var element = '<li class="span3 gallery-item" data-id="id-1"data-type="illustration"><span class="project-details"><a href="artist?id='+item.id+'">'+item.username+'</a></span></li>';
    		$('#artists_results').append(element);
        })
        $.each(data.albums, function(i, item) {
        	var element = '<div class="span2"><img src="data:image/png;base64,'+item.cover+'" class="thumbnail"/>'+
            '<h5>'+item.title+'</h5><h5>'+item.artists[0].username+'</h5></div>';
        	$('#albums_results').append(element);
        })
		},
		error: function (e) {
		alert('error');
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