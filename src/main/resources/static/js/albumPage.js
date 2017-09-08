var id = getParameterByName('id');
	
	$.ajax({ 
        type: "GET",
        url: "/album/"+id,
        success: function (data) {
        	var artists = ""
        	$.each(data.artists, function(i, item) {
        	  		artists += item.username
            })
            var genres = ""
            	$.each(data.genres, function(i, item) {
            		genres += item.title
            })
        		$("#title").text(data.title);
        		$("#tags").text(data.tags);
        		$("#artists").text(artists);
        		$("#genres").text(genres);
        		$("#cover").append('<img src="data:image/png;base64,'+data.cover+'" alt="Image"/>');
        		
        	$.each(data.tracks, function(i, item) {
        			var track =  '<li><h6>'+item.title+'</h6><audio controls="controls"><source src="data:audio/mpeg;base64,'+item.audio+'"></source></audio></li>';
        			$('#tracklist').append(track);   
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