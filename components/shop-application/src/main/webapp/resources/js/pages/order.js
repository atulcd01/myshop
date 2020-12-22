function gup( name, url ) {
		    if (!url) url = location.href;
		    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
		    var regexS = "[\\?&]"+name+"=([^&#]*)";
		    var regex = new RegExp( regexS );
		    var results = regex.exec( url );
		    return results == null ? null : results[1];
		}

function orderController($scope, $http, $window,$rootScope) {
	$scope.pageToGet = 0;

	$scope.state = 'busy';

	$scope.lastAction = '';
	var pId = window.location.href.split(/[\s/]+/).pop();
	var loc = pId.split('?');
	pId = loc[0];
	$scope.pId = pId;
	$scope.parameter = loc[1];

	$scope.url = $rootScope.contextpath+"/order-service/protected/order/";
	

	$scope.displayValidationError = false;

	$scope.address = {}
	
	 $scope.email;
	
	$scope.total = $window.localStorage.getItem('total');
console.log($scope.total);
    $scope.getUserEmailfromSession = function () { 
    	
    	try {
    		$scope.user = $window.sessionStorage.getItem('user');
	    	$scope.user = JSON.parse($scope.user);
	    	$scope.email = $scope.user.email;
  
    	}
    	catch(err) {
    		$scope.email = null;
    		}
    }

	$scope.getAddressList = function () {
		var url = $scope.url+'address';
		$scope.lastAction = 'list';

		$scope.startDialogAjaxRequest();

		var config = {params: {page: $scope.pageToGet},headers: {'email': $scope.email}};

		$http.get(url, config)
		.then(function (data) {
			//alert(JSON.stringify(data));
			$scope.finishAjaxCallOnSuccess(data.data, null, false);
		},function () {
			$scope.state = 'error';
		});
	}

	

	$scope.populateTable = function (data) {
		$scope.page = {source: data.addressList};
	}
	
	

	$scope.startDialogAjaxRequest = function () {
		$scope.displayValidationError = false;
		$("#loadingModal").modal('show');
		$scope.previousState = $scope.state;
		$scope.state = 'busy';
	}

	
	
	$scope.finishAjaxCallOnSuccess = function (data, modalId, isPagination) {
		$scope.populateTable(data);
		$("#loadingModal").modal('hide');
		if(!isPagination){
			if(modalId){
				$scope.exit(modalId);
			}
		}
		$scope.lastAction = '';
	}



	$scope.addAddress = function () {
		/*if (!newAddressForm.$valid) {
			$scope.displayValidationError = true;
			return;
		}*/
		alert(JSON.stringify($scope.address) );
		$scope.lastAction = 'addaddress';
		var url = $scope.url+'add';
		var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8','email': $scope.email}};
		//var config = {headers: {'email': $scope.email}};
		$scope.startDialogAjaxRequest();
		$http.post(url, $.param($scope.address), config)
		.then(function (data) {
			$scope.finishAjaxCallOnSuccess(data.data, "#addAddressModal", false);
			$scope.getAddressList();
		},function(data, status, headers, config) {
			$scope.handleErrorInDialogs(status);
		});
	};
	
	
	
	$scope.closeall = function () {
		$scope.tooglelogin = false;
		$scope.tooglelogindiv = false;
		$scope.tooglelogoutdiv = false;
		$scope.toogleaddress = false;
		$scope.toogleorder = false;
		$scope.tooglepayment = false;
		$scope.confirm = false;
	}

	
	
	$scope.closeall();
	
	$scope.logout = function () {
		//alert($window.sessionStorage.getItem('user'));
		$http.post('/login/logout').then(function () { 
			$window.sessionStorage.setItem('user',null);
			$scope.tooglelogindiv=true;
			$scope.toogleloginreg=false;
			$scope.user={};
		},function () { 
		});
	}

	
	$scope.user={};
	
	$scope.setUserFromSession = function (){
		$scope.user = JSON.parse($window.sessionStorage.getItem('user'));
		//alert('session has this user --->'+$window.sessionStorage.getItem('user'));
	}
	
	$scope.setUserFromSession();
	
	
	$scope.isAuthenticated = function(){
		if($window.sessionStorage.getItem('user')!= null && $window.sessionStorage.getItem('user')!= 'null')
			return true;
		else 
		   return false;
	};
	
	
	$scope.checkLogin = function () {
		//alert($window.sessionStorage.getItem('user'));
		if($scope.tooglelogin)
			$scope.tooglelogin= false;
		else{
			$scope.closeall();
			$scope.tooglelogin= true;
			if($scope.isAuthenticated()){
				$scope.user = JSON.parse($window.sessionStorage.getItem('user'));
				$scope.tooglelogindiv=false;
			}else{
				$scope.tooglelogindiv=true;
			}
		}
	}
	
	

	$scope.loginerrmsg='';
	
	$scope.login = function () {
		var url = '/login/login/?'+$scope.parameter;
		var logindata = {'email': $scope.email, 'password': $scope.password, 'applicationId':gup('a', url)};
		$scope.lastAction = 'login';
		
		var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
		$scope.startDialogAjaxRequest();
		//alert(JSON.stringify(logindata) + $scope.username);
		$http.post(url, JSON.stringify(logindata))
		.then(function (data) {
			//alert(JSON.stringify(data));
			$scope.login.loginerrmsg='';
			$scope.tooglelogindiv=false;
			$window.sessionStorage.setItem('user', JSON.stringify(data.data));
			$scope.setUserFromSession();
			$scope.getAddressList();
			//add address
			// add cart
			//alert("success"); 
		},function(data, status, headers, config) {
			$scope.loginerrmsg = 'username or password is incorrect';
		});
	}


	$scope.toogleloginregf = function () { 
		if($scope.toogleloginreg)
			$scope.toogleloginreg=false;
		else
			$scope.toogleloginreg=true;
	}
	
	
	
	$scope.toogleaddressf = function () { 

		var auth = $scope.isAuthenticated();
		if(auth){
			if($scope.toogleaddress)
				$scope.toogleaddress=false;
			else{
				$scope.closeall();
				$scope.toogleaddress=true;
			}
		}else
			$scope.toogleaddress=false;
	}
	
	
	$scope.toogleorderf = function () { 
		//alert(JSON.stringify($scope.cart));
		var auth = $scope.isAuthenticated();
		if(auth && ($scope.cart!= undefined || $scope.cart!=null)){
			if($scope.toogleorder)
				$scope.toogleorder=false;
			else{
				$scope.closeall();
				$scope.toogleorder=true;
			}
		}else
			$scope.toogleorder=false;
	}
	
	
	$scope.tooglepaymentf = function () { 
		if($scope.confirm){
			if($scope.tooglepayment)
				$scope.tooglepayment=false;
			else{
				$scope.closeall();
				$scope.tooglepayment=true;
			}
		}else
			$scope.tooglepayment=false;
	}
	
	
	$scope.confirmOrder = function () { 
		
		$scope.confirm = true;
		$scope.tooglepaymentf();
	}
	
	
	$scope.registerUser = function () { 
		$scope.reguser.role='ROLE_USER';
		$scope.reguser.enabled=true;
		$scope.lastAction = 'addaddress';
		var url = '/login/register/'+$scope.parameter;
		$scope.reguser.applicationId=gup('a', url);
		//alert(JSON.stringify($scope.reguser));
		var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};
		$scope.startDialogAjaxRequest();
		$http.post(url, $.param($scope.reguser), config)
		.then(function (data) {
			//alert(JSON.stringify(data));
			$window.sessionStorage.setItem('user', JSON.stringify(data.data));
			$scope.setUserFromSession();
			$scope.finishAjaxCallOnSuccess(data, "#loginModal", false);
			$scope.login.loginerrmsg='';
			$scope.tooglelogindiv=false;
		},function(data, status, headers, config) {
			$scope.loginerrmsg = 'user cannot be registered';
			//   $scope.handleErrorInDialogs(status);
		});
	};




	$scope.removeAddress = function (id) {
		//alert(id);
		var url = $scope.url+"remove/"+id;
		$scope.lastAction = 'list';

		$scope.startDialogAjaxRequest();

		var config = {params: {page: $scope.pageToGet}};

		$http.get(url, config)
		.then(function (data) {
			//alert(JSON.stringify(data));
			//$scope.finishAjaxCallOnSuccess(data, null, false);
			$scope.getAddressList();
		},function () {
			$scope.state = 'error';
		});
	}



//this part has to be changed
	$scope.addAddressToDelivery = function (address) { 
		 var url = $rootScope.contextpath+'/cart-service/protected/cart?'+$scope.parameter;
		$scope.deliveryAdId = address.id;
		$scope.startDialogAjaxRequest();
		var config = {headers: {'email': $scope.email}};
		//alert(url);
		$http.get(url, config)
		.then(function (data) {
			//alert(JSON.stringify(data));
			data = data.data;
			 $scope.total = 0;
			angular.forEach(data.cartList, function(cart){
   	         
	    		
    	        $scope.getProductById(cart);
    	        
    	   });
			$scope.cart = {source: data.cartList, deliveryAdId : address.id,total: data.total};
			$scope.toogleorderf();
		},function () {
			$scope.state = 'error';
		});
	}

	 $scope.getProductById = function (cart) {

	    	var url = $rootScope.contextpath+"/category-service/category/product/"+cart.productId;
	    	
	    	 console.log('url - >'+url);
	    	 $http.get(url)
	        .then(function (data) {
	        	console.log('success');
	        	 cart.product =  data.data;
	             $scope.total = eval($scope.total + cart.product.someadditionalattr.prize*cart.qty);
	        },function (data) {
	        	console.log("error" + JSON.stringify(data));
	            $scope.state = 'error';
	           
	        });
	}



	$scope.createOrder = function (address) { 
		var url = $scope.url+'create?'+$scope.parameter;
	
		$scope.startDialogAjaxRequest();
		var json = angular.toJson( $scope.cart );
		console.log(json);
		var config = {headers: {'Content-Type': 'application/json; charset=UTF-8','email': $scope.email}};
		$http.post(url, json, config)
		.then(function (data) {
			//add remove
			angular.forEach($scope.cart.source, function(cart){
				
				$scope.removeFromCart(cart.id);
    	   });
			alert('success');
		},function(data) {
			alert(JSON.stringify(data))
		});
		 
	}

	$scope.removeFromCart = function (cartId) {
        // alert(productId);
    	//alert(index);
     	var url = $rootScope.contextpath+"/cart-service/protected/cart/"+cartId+"/remove";
         $scope.startDialogAjaxRequest(); 

         var config = {headers: {'email': $scope.email}};
        
         $http.post(url,$.param($scope.parameter), config)
             .then(function (data) {
             	//alert(JSON.stringify(data));
             },function () {
                 $scope.state = 'error';
             });
     }

	$scope.exit = function (modalId) {
		$(modalId).modal('hide');
		$scope.address = {};
	} 

	$scope.getUserEmailfromSession();
	$scope.getAddressList();
}