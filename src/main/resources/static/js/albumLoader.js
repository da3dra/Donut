$(document).ready(function () {
	$.ajax({ 
        type: "GET",
        url: "/albums/1",
        success: function (data) {
        	
        	// разобраться как применить этот метод и к главной странице, и к стр. с альбомами
        	$.each(data, function(i, item) {
        		var artists = []
        		artists = item.artists;
        		var element = '<li class="span3 gallery-item" data-id="id-1"data-type="illustration"><img src="img/'+item.cover+'" alt="Gallery"/><span class="project-details"><a href="gallery-single.htm">'+item.title+'</a>'+item.artists[0].name+'</span></li>';
        		$('#new_albums').append(element);
            })
        },
        error: function (e) {
         alert('error');
        }
});
});