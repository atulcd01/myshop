function productsController($scope, $http,$rootScope) {
	
	var pId = window.location.href.split(/[\s/]+/).pop();
	//alert(window.location.href);
	//alert(pId);
	var loc = pId.split('?');
	pId = loc[0]; 
	$scope.pId = pId;
	
    $scope.pageToGet = 0;

    $scope.state = 'busy';

    $scope.lastAction = '';

    $scope.url = $rootScope.contextpath+"/search-service/protected/products/"+pId;

    $scope.record = {}
    
    $scope.toogleFilterElement = function ($event) {
    	
    	//alert($($event.currentTarget).next().is(":visible") );
    	if ($($event.currentTarget).next().is(":visible") ) {
    		$($event.currentTarget).next().hide();
    		$($event.currentTarget).children("svg").css("transform", "rotate(-90deg)");
    		
    		//$($event.currentTarget).children("svg").removeClass("_2Gnm9R");
    	}
    	else{
    		$($event.currentTarget).next().show();
    		$($event.currentTarget).children("svg").css("transform", "rotate(90deg)")
    	}
    }

    $scope.getRecordList = function () {
        var url = $scope.url;
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

            $scope.page = {source: data.products, currentPage: $scope.pageToGet, pagesCount: data.pagesCount, totalProduct : data.totalProduct};

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
    	
    }
}