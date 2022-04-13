function addToCart(id) {
	fetch(`api/cart/${id}`).then(res => res.json()).then(data => {
		var d = document.getElementById("cartCouter");
		if(d != null){
			d.innerHTML = data;
		}
	})
}
function update(obj, id){
	fetch(`api/cart/${id}`).then(res => res.json()).then(data => {
		var d = document.getElementById("cartCouter");
		if(d != null){
			d.innerHTML = data;
		}
	})
	console.info(obj.value);
}
