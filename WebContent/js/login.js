/*$("#loginForm").submit(function(evt) {
		evt.preventDefault();*/
function loginuser(){
		console.log("username=",$("#uname").val());
		console.log("psw=",$("#psw").val());
		
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
}  
	//});


function controllauser(){
	console.log("il valore di username is"+$("#usrreg").val());
	/*if($.trim($("#usrreg").html())=='')
	{	 console.log("sono in cotrolla user- primoif e vale"+$("#usrreg").val());
		 $("#availability").text("").css({ 'color': 'blue', 'font-size': '100%' });
	}
	else{*/ console.log("sono in cotrolla user- parte ajax");
	$.ajax({
		
		type : "POST",
		url : "AccessServlet?action=checkusername",
		datatype : "json",
		data : { 
					datapkt : JSON.stringify({"useridea": $("#usrreg").val()} )
			
				},
		
		success: function(data){
			
			if(data==1){
			 $("#availability").text("username disponibile").css({ 'color': 'green', 'text-align': 'center', 'font-size': '100%' });
			 
			}
			else if(data==0)
			{
			 $("#availability").text("username gia' in uso").css({ 'color': 'red', 'font-size': '100%' });
			}
		
		}//success	
				
								
	}); //ajax

	//}//else empty
}




	$("#registerForm").submit(function(evt) {
		evt.preventDefault();
		
		     $.ajax({
		    	 
		           type : "POST",
		 			url : "AccessServlet",
		 			data: { "action" : 'register',
		 					"uname" : $("#usrreg").val(),
		 					"psw" : $("#pswreg").val(),
		 					"nome" : $("#nome").val(),
		 					"cognome" : $("#cognome").val(),
		 			},
		     success: function (data) {
		    	         
		        if(data==1)
		        	{
		        	
		        	console.log("registrazione effettuata");
		        	afterLogin();
			
		        	}
		        else if(data==0)
		        	{
		        	
		        	console.log("errore");
		        	}
		        else if(data==2)
	        	{
	        	
	        	console.log("username esistente");
	        	}
		        else if(data==3)
	        	{
	        	
	        	console.log("errore! controlla i dati inseriti");
	        	}
		      
		     },//success
		     	error: function(xhr, status, error) {
		 
		    	  alert(xhr.responseText);
		    	}

		     });//ajax 
	});