
function trackOrderController($scope, $http, $window,$rootScope) {
	
	var orderId = window.location.href.split(/[\s/]+/).pop();

	//alert(orderId+'orderId');
	$scope.orderId = orderId;
	
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    $scope.url = $rootScope.contextpath+"/order-service/protected/order/track/"+orderId;
    //$scope.url = "/protected/trackorder/"+orderId;

    $scope.record = {}
    

    $scope.getRecordList = function () {
        var url = $scope.url;
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest(); 

        var config = {params: {page: $scope.pageToGet}};
//alert(url)
        $http.get(url, config)
            .then(function (data) {
            	//alert(JSON.stringify(data));
                $scope.finishAjaxCallOnSuccess(data.data, null, false);
            },function () {
            	//alert('error');
                $scope.state = 'error';
            });
    }


    $scope.populateTable = function (data) {

            $scope.page = {order: data.order, address: data.address, messagelist: data.messagelist , quantity: data.quantity , total: data.total};

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
    

    $scope.getRecordList();
    
    
    
    $scope.init = function (result) {
    	
    };
    
    
}