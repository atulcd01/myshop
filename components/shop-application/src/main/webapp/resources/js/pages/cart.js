function cartController($scope, $http,$rootScope, $window) {
	var pId = window.location.href.split(/[\s/]+/).pop();
	var loc = pId.split('?');
	pId = loc[0];
	$scope.pId = pId;
	$scope.parameter = loc[1];
	
	$scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    $scope.url = $rootScope.contextpath+"/cart-service/protected/cart/?"+$scope.parameter;

    $scope.record = {}
    
    $scope.count=0;
    
    $scope.total=0;
   
    
    $scope.user;
    $scope.email;

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
    
    $scope.getRecordList = function () {
        var url = $scope.url;
        //alert(url);
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest();

        var config = {headers: {'email': $scope.email}};

        $http.get(url, config)
            .then(function (data) {
            	//alert(JSON.stringify(data));
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
            },function () {
                $scope.state = 'error';
            });
    }

    $scope.showAddTotal = function (product,page, prize) {
    	page.total = page.total + prize;
    	
    	$scope.total = $scope.total + prize; 
    	product.qty = product.qty + 1;
    	var config = {headers: {'email': $scope.email}};
    	var url = $rootScope.contextpath+"/cart-service/protected/cart/add/"+product.id;
    	
    	$http.get(url,config)
        .then(function (data) {
            console.log("success");
        },function () {
            $scope.state = 'error';
        });
    	$window.localStorage.setItem('total',$scope.total);
    }
    
    $scope.showSubTotal = function (product,page, prize) {
    	page.total = page.total - prize;
    	$scope.total = $scope.total - prize;
    	product.qty = product.qty - 1;
    	var config = {headers: {'email': $scope.email}};
    	var url = $rootScope.contextpath+"/cart-service/protected/cart/sub/"+product.id;
    	$http.get(url,config)
        .then(function (data) {
        	 console.log("success");
        },function () {
            $scope.state = 'error';
        });
    	$window.localStorage.setItem('total',$scope.total);
    }
    
    
    $scope.populateTable = function (data) {
    	
    	angular.forEach(data.cartList, function(cart){
    	         
    		
    	        $scope.getProductById(cart);
    	        
    	   });
            $scope.page = {source: data.cartList, count: data.count, total: data.total};
            $scope.data = data;
            $scope.count = data.count;

    }
    
    $scope.getProductById = function (cart) {

    	var url = $rootScope.contextpath+"/category-service/category/product/"+cart.productId;
    	
    	 console.log('url - >'+url);
    	 $http.get(url)
        .then(function (data) {
        	console.log('success');
        	 cart.product =  data.data;
             $scope.total = $scope.total + (cart.product.someadditionalattr.prize * cart.qty);
             $window.localStorage.setItem('total',$scope.total);
             console.log($window.localStorage.getItem('total'));
        },function (data) {
        	console.log("error" + JSON.stringify(data));
            $scope.state = 'error';
           
        });
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
        
        $scope.total = 0;
    }
    
    
    
    $scope.removeFromCart = function (productId,index) {
        // alert(productId);
    	//alert(index);
     	var url = $rootScope.contextpath+"/cart-service/protected/cart/"+productId+"/remove";
         

         $scope.startDialogAjaxRequest(); 

         var config = {headers: {'email': $scope.email}};
        
         $http.post(url,$.param($scope.parameter), config)
             .then(function (data) {
             	//alert(JSON.stringify(data));
             	document.getElementById("cartTable").deleteRow(eval(index+1));
             	$scope.count = $scope.count-1;
             	
             	
             	var ele = document.getElementById('cartfacade');
            	var val = ele.innerHTML;
            	ele.innerHTML = $scope.count;
            	var ele = document.getElementById('cartfacade1');
            	var val = ele.innerHTML;
            	ele.innerHTML = $scope.count;
             	
             },function () {
                 $scope.state = 'error';
             });
     }
    
    
    
    
    
    
    
    
    
$scope.getUserEmailfromSession();
$scope.getRecordList();
}