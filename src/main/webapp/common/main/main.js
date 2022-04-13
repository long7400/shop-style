function addToCart(id) {
	fetch(`api/cart/${id}`).then(res => res.json()).then(data => {
		var d = document.getElementById("cartCouter");
		if(d != null){
			d.innerHTML = data;
		}
	})
}
function updateCart(obj, id){
	fetch("http://localhost:8080/shop-style/home-page/api/cart",{
		method: "PUT",
		body: JSON.stringify({
			"product_id": id,
			"product_name": "",
			"cart_id": "",
			"price": 0,
			"quantity": obj.value 
		}),
		headers:  { 'Accept': 'application/json', 
		'Content-Type': 'application/json' }
	}).then(function(res){
		return res.json() 
	}).then(function(data){
		var d = document.getElementById("cartCouter");
		if(d != null){
			d.innerHTML = data
		}
	})
	console.info(obj.value);
}


function deleteCart(id){
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
