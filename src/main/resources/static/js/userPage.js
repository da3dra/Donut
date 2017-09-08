	var id = getParameterByName('id');
	
	$.ajax({ 
        type: "GET",
        url: "/user/"+id,
        success: function (user) {
        	$.each(user.news, function(i, item) {
        		var content = ""
        		content+='<li class = "feed_post"><a href="'+item.content_link+'"><img class="preview" src="data:image/png;base64,'+item.image+'"/></a>'+
                    '<h5 class = "feed_post_text">'+item.title+'</h5><em>Posted on 09/01/15</em></li>'
        		$("#feed").append(content);
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
	
