<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet"/>
	</head>
	
	<body onload="load();">
		<form role="form" class="form-inline">	
			<div class="form-group">
				<input type="hidden" id="user_id">
				**Full Name of User: <input type="text" id="name" required="required" name="user_name"><br>
			</div>
			
			**Email of User: <input type="email" id="email" required="required" name="email"><br>
				<button class="btn-primary" onclick="add();" >Add/Update User</button>
		</form>
		<table class="table table-bordered table-striped table-hover" id="table" border=1>
			<tr > <th> Id </th> <th> Name </th> <th> Email </th> <th> Edit </th> <th> Delete </th> </tr>
		</table>
	
		Search By user id: <input type="text" id="user_id_to_search" name="user_id"><br>
		<button class="btn-primary" onclick="search();">Search User</button>
		<div class="table table-bordered table-striped table-hover" id="here_table"></div>
			<script type="text/javascript">
			data = "";
			search = function(){
			 
			$.ajax({
				url:'userss',
				type:'GET',
				data:{user_id:$("#user_id_to_search").val()},
				success: function(response){
					if(response.User)
						{
							$('.searchResult').remove();
							var table = $('<table id="table1"; class="searchResult table table-bordered table-striped table-hover"  border=1></table>').addClass('foo');			
							var row = $('<tr><th> Id </th> <th> Name </th> <th> Email </th></tr>');
							table.append(row);
							row = $('<tr class="searchResultRow"> <td> '+ response.User.user_id+ ' </td> <td> ' + response.User.user_name+ '</td> <td>' + response.User.email + ' </td>  </tr>');
							table.append(row);
							$('#here_table').append(table);					
						}
					else
						{
							alert( response.message)
						}
					}				
				});			
			}
			
			add = function(){
				$.ajax({
				url:'users',
				type:'POST',
				data:{user_id:$("#user_id").val(),user_name:$('#name').val(),email:$('#email').val()},
				success: function(response){
					alert(response.message);
					load();		
				}				
			});			
		}
		
			delete_ = function(id){		 
			 	$.ajax({
					url:'deleteusers',
					type:'POST',
					data:{user_id:id},
					success: function(response){
						alert(response.message);
						load();
					}				
				});
			}
	
			edit = function (index){
				$("#user_id").val(data[index].user_id);
				$("#name").val(data[index].user_name);
				$("#email").val(data[index].email);
			}
		
			load = function(){	
				$.ajax({
				url:'users',
				type:'GET',
				success: function(response){
					data = response.data;
					$('.userDataRow').remove();
					for(i=0; i<response.data.length; i++){					
						$("#table").append("<tr class='userDataRow'> <td> "+response.data[i].user_id+" </td> <td> "+response.data[i].user_name+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
					}			
				}				
			});	
		}
		</script>	
	</body>
</html>