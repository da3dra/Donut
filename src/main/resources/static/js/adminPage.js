$(document).ready(function () {
	
	$.ajax({ 
        type: "GET",
        url: "/artists",
        success: function (data) {
        	$.each(data, function(i, item) {
        	     var toAppend;
        	      toAppend += '<tr id="'+item.id+'">'+
        			'<td><span id="'+item.id+'">'+item.id+'</span></td>'+
        			'<td><a href = "artist?id='+item.id+'"><span id="'+item.username+'">'+item.username+'</span></a></td>'+
        			'<td><span id="'+item.email+'">'+item.email+'</span></td>'+
        			'<td><span id="'+item.donuts+'">'+item.donuts+'</span></td>'+
        			'<td id="status_'+item.id+'"><span>'+item.status+'</span></td>'+
        			'<td class="delete"><button disabled="true" class = "save_btn" id="'+item.id+'">Save</button><button class = "edit_btn" id="'+item.id+'">Edit</button></td>'+
					'</tr>';
        		 $('#artistlist').append(toAppend);
            })
        },
        error: function (e) {
         alert('get albums error');
         
        }
	});
	
	var statuses;
	
	$.ajax({ 
        type: "GET",
        url:  "statuses",
        success: function (data) {
        	statuses=data;
        },
        error: function (e) {
         alert('approve error');
        }
	});	
	
	$("#wrapper_admin").on("click", ".edit_btn", function() { 
	 	$('#status_'+this.id).empty();
		var statusList = '<select name="status" id="status_in_'+this.id+'">';
			$.each(statuses, function(i, item) {
				statusList+='<option th:field="*{status}" value="'+item+'">'+item+'</option>';
			})
		statusList+='</select>';
		$('#status_'+this.id).append(statusList);
		// сделать так чтоб разблокировать только одну необходимую кнопку!!
		$('.save_btn ').prop('disabled', false);	
	});

	$("#wrapper_admin").on("click", ".save_btn", function() { 
		var status = $('#status_in_'+this.id).val();		
			$.ajax({ 
		        type: "POST",
		        url:  "artist/"+this.id+"/status/"+status,
		        success: function (data) {
		        	  location.reload();    
		        	   },
		        error: function (e) {
		         alert('set status error');
		        }
			});		
	});
	
});

