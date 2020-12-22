
function ordersViewController($scope, $http, $window,$rootScope) {
	
	var pId = window.location.href.split(/[\s/]+/).pop();
	//alert(window.location.href);
	//alert(pId);
	$scope.pId = pId;
	var loc = pId.split('?');
	pId = loc[0]; 
	$scope.pId = pId;
	$scope.parameter = loc[1];
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    //$scope.url = "/protected/vieworder";
    $scope.url = $rootScope.contextpath+"/order-service/protected/order/?"+$scope.parameter;
    console.log($scope.url)
    $scope.record = {}
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
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest(); 
        var config = {params: {page: $scope.pageToGet}, headers: {'email': $scope.email}};

        $http.get(url, config)
            .then(function (data) {
            	//alert(JSON.stringify(data.data));
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
            },function () {
            	alert('error');
                $scope.state = 'error';
            });
        
       
    }


    $scope.populateTable = function (data) {
            $scope.page = {source: data.orders, currentPage: $scope.pageToGet, pagesCount: data.pagesCount, totalOrder : data.totalOrder};
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
    
    $scope.trackOrder = function(url) {
      console.log(url);
    	window.location.href = url
    };
    
    $scope.getUserEmailfromSession(); 
    $scope.getRecordList();
    
    console.log('after loadingModal');
    
    $scope.init = function (result) {
    	
    };
    
    /*$scope.trackOrder = function (orderId) {
    	
    	location.href='/protected/trackorder/'+orderId;
    };*/
}