function viewController($scope, $http, $window,$rootScope) {
	
	var pId = window.location.href.split(/[\s/]+/).pop();
	var loc = pId.split('?');
	pId = loc[0];
	$scope.pId = pId;
	$scope.parameter = loc[1];
	
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    $scope.url = $rootScope.contextpath+"/search-service/protected/products/"+pId;

    $scope.record = {}
    
    $scope.incart = false;
    

    $scope.getRecordList = function () {
        var url = $scope.url;
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest(); 

        var config = {params: {page: $scope.pageToGet}};

        $http.get(url, config)
            .then(function (data) {
            	//alert(JSON.stringify(data));
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
               // $scope.identifyCart();
            },function () {
                $scope.state = 'error';
            });
    }


    $scope.populateTable = function (data) {

            $scope.page = {source: data.products, product: data.products[0], currentPage: $scope.pageToGet, pagesCount: data.pagesCount, totalProduct : data.totalProduct};
            $('#breadcrumb').html($scope.page.product.breadcrumb);
           // document.getElementById('breadcrumb').innerHTML = $scope.page.product.breadcrumb;
           // alert(document.getElementById('breadcrumb').innerHTML)
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
    
    $scope.changePage = function (page) {
        $scope.pageToGet = page;
        
        $scope.getRecordList();
       
    };
    
    $scope.goToCart = function () {
    	location.href='/protected/cart?'+$scope.parameter
    }
    
    
    $scope.isAuthenticated = function(){
		if($window.sessionStorage.getItem('user')!= null && $window.sessionStorage.getItem('user')!= 'null')
			return true;
		else 
		   return false;
	};
	
    
    $scope.addToCart = function () {
        
    	var url = $rootScope.contextpath+"/cart-service/protected/cart/"+pId+"/addtocart?"+$scope.parameter;

     //   $scope.startDialogAjaxRequest(); 

    	 var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8','email': $scope.email}};
    	 
    	 $http.post(url, $.param($scope.parameter), config)
            .then(function (data) {
            	//alert($scope.email + '==' + data.data.email)
            	var ele = document.getElementById('cartfacade');
            	var val = ele.innerHTML;
            	ele.innerHTML = eval(eval(val)+1);
            	var ele = document.getElementById('cartfacade1');
            	var val = ele.innerHTML;
            	ele.innerHTML = eval(eval(val)+1);
            	$scope.incart = true;
            },function () {
            	alert('error');
                $scope.state = 'error';
            });
    }
    

    
    $scope.identifyCart = function () {
    	  
    	var url = $rootScope.contextpath+"/cart-service/protected/cart/check/"+pId+"?"+$scope.parameter;
            $scope.startDialogAjaxRequest();
//alert(url);
    	//alert('email ->'+$scope.email);
    	 var config = {headers: {'email': $scope.email}};

            $http.get(url, config)
                .then(function (data) {
                	//alert(data.data.inCart);
                	$scope.incart = data.data.inCart;
                },function () {
                    $scope.state = 'error';
                });
        }
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
   
    $scope.getUserEmailfromSession();
    $scope.getRecordList();
    $scope.identifyCart();
    
    
    
    
}