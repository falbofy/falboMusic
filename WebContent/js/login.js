	$("#loginForm").submit(function(evt) {
		evt.preventDefault();
		console.log("username=",$("#uname").val());
		console.log("psq=",$("#psw").val());
		
		     $.ajax({
		    	 
		           type : "POST",
		 			url : "AccessServlet",
		 			data: { "action" : 'login',
		 					"uname" : $("#uname").val(),
		 			
		 					"psw" : $("#psw").val()
		 			},
		     success: function (data) {
		    	         
		        if(data==1)
		        	{
		        	$("#sb-search").hide();
		        	console.log("sono inlogin effettuato");
		        	afterLogin();
			
		           /* $("#b1").remove();//prop("disabled",true);
		        	$("#goback").show();*/
		        	}
		        else if(data==0)
		        	{
		        	
		        	console.log("sono inlogin errato");
		        	}
		      
		     },//success
		     	error: function(xhr, status, error) {
		 
		    	  alert(xhr.responseText);
		    	}

		     });//ajax
		   	
	    
	});
	