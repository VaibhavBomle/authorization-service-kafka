<div class="container">
		<table class="table table-striped" border="2">
			
			<thead  >
				<tr>
					<th>Address</th>
					<th>Phone Number</th>
					<th>Action</th>
					
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${userProfile.address}</td>
						
						<td>${userProfile.phoneNumber}</td>
						<td><a type="button" class="btn btn-success"
							href="./update-user?id=${userProfile.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="./delete-user?id=${userProfile.id}">Delete</a></td>
					</tr>
			</tbody>
		</table>
		
	</div>