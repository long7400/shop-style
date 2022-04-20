function addToCart(id) {
	fetch(`api/cart/${id}`).then(res => res.json()).then(data => {
		var d = document.getElementById("cartCouter");
		if(d != null){
			d.innerHTML = data;
		}
	})
}



function deleteCart(id){
	if(confirm("Bạn có muốn xóa không ?") == true){
		fetch(`http://localhost:8080/shop-style/home-page/api/cart/${id}`,{
			method: "DELETE"
		}).then(function(res){
			return res.json() 
		}).then(function(data){
			var d = document.getElementById("cartCouter");
			if(d != null){
				d.innerHTML = data
				location.reload()
			}
		})
	}
}
