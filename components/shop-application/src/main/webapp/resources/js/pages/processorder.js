
function ordersController($scope, $http, $window,$rootScope) {
	
	var pId = window.location.href.split(/[\s/]+/).pop();
	//alert(window.location.href);
	//alert(pId);
	$scope.pId = pId;
	
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    //$scope.url = "/protected/processorder";
    $scope.url = $rootScope.contextpath+"/order-service/protected/order";
    $scope.record = {}
    

    $scope.getRecordList = function () {
        var url = $scope.url+"/orders";
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest(); 

        var config = {params: {page: $scope.pageToGet}};

        $http.get(url, config)
            .then(function (data) {
            	//alert(JSON.stringify(data));
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
            },function () {
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
    
    
    
    
    $scope.getRecordList();
    
    
    
    $scope.init = function (result) {
    	
    };
    
    $scope.completeTask = function (orderdetails) {
    	
    	 var url = $scope.url+"/completetask";

    	var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};

    	
    	
    	
    	 $http.post(url, $.param(orderdetails), config)
         .then(function (data) {
        	 orderdetails.status = data.data.status;
           //  $scope.finishAjaxCallOnSuccess();
         
         }).catch(function(e) {
             console.log('Error: ', e);
             throw e;
         }).finally(function() {
             console.log('This finally block');
         });;
    };
}