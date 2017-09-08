$(document).ready(function () {
/*	$.ajax({ 
        type: "GET",
        url: "/albums/1",
        success: function (data) {
        	$.each(data.content, function(i, item) {
        		var artists = []
        		artists = item.artists;
            	var element =    '<li  class="span2 gallery-item" data-id="id-1" data-type="illustration">'+
                '<span class="gallery-hover-6col hidden-phone hidden-tablet"></span>'+
                '<a href="gallery-single.htm"><img src="img/'+item.cover+'" alt="Gallery"></a>'+
                '<span class="project-details"><a href="gallery-single.htm">'+item.title+'</a>'+item.artists[0].name+'</span></li>';	
	        		$('#content').append(element);
            })
        },
        error: function (e) {
         alert('error');
        }
});*/
	$.ajax({ 
        type: "GET",
        url: "/genres",
        success: function (data) {
        	$.each(data, function(i, item) {
        		var element = '<li id="'+item.id+'">'+item.title+'</li>';
        		$('#genres').append(element);
            })
        },
        error: function (e) {
         alert('error');
        }
});
	$("#genres").on("click", "li", function() {
		$.ajax({ 
	        type: "GET",
	        url: "/genre/"+item.id,
	        success: function (data) {
	        	$.each(data, function(i, item) {
	        		var artists = []
	        		artists = item.artists;
	        	var albums =    '<li  class="span2 gallery-item" data-id="id-1" data-type="illustration">'+
                '<span class="gallery-hover-6col hidden-phone hidden-tablet"></span>'+
                '<a href="gallery-single.htm"><img src="img/gallery/gallery-img-1-6col.jpg" alt="Gallery"></a>'+
                '<span class="project-details"><a href="gallery-single.htm">'+item.title+'</a>'+item.artists[0].name+'</span></li>';	
	        		$('#content').append(element);
	            })
	        },
	        error: function (e) {
	         alert('error');
	        }
	});
	});
	
	
	
	
	
	
});

