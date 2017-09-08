$(document).ready(function () {
	var id = getParameterByName('id');
	$.ajax({ 
        type: "GET",
        url: "/artist/"+id+"/albums",
        success: function (data) {
        	$.each(data, function(i, item) {
        	     var toAppend;
        	 	var tracks = ""
        	 	$.each(item.tracks, function(i, track) {
        	 		tracks += '<audio controls="controls"><source src="data:audio/mpeg;base64,'+track.audio+'"></source></audio>'
        	 	})
        	      toAppend += '<tr id="'+item.id+'">'+
        			'<td class="title"><span id="'+item.title+'">'+item.title+'</span></td>'+
        			'<td class="genre"><span id="'+item.genres+'">'+item.genres+'</span></td>'+
        			'<td class="tags"><span id="'+item.tags+'">'+item.tags+'</span></td>'+
        			'<td class="status"><span id="'+item.status+'">'+item.status+'</span></td>'+
        			'<td class="cover"><img class ="preview" src="data:image/png;base64,'+item.cover+'"/></td>'+
        			'<td class="tags"><span>'+tracks+'</span></td>'+
        			'<td class="approve"><button class = "approve_btn" id="'+item.id+'">Approve</button><button class = "ban_btn" id="'+item.id+'">Ban</button></td>'+
					'</tr>';
        		 $('#albumlist').append(toAppend);
            })
        },
        error: function (e) {
         alert('get albums error');
        }
	});
	
	$("#wrapper_admin").on("click", ".approve_btn", function() { 
		$.ajax({ 
	        type: "POST",
	        url:  "approve/artist/"+id+"/album/"+this.id,
	        success: function (data) {
	        	  location.reload();    
	        	   },
	        error: function (e) {
	         alert('approve error');
	        }
		});		
	});
	
	$("#wrapper_admin").on("click", ".ban_btn", function() { 
		$.ajax({ 
	        type: "POST",
	        url:  "ban/artist/"+id+"/album/"+this.id,
	        success: function (data) {
	        	  location.reload();    
	        	   },
	        error: function (e) {
	         alert('approve error');
	        }
		});		
	});
	
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