//alert('from category page');
function gup( name, url ) {
		    if (!url) url = location.href;
		    name = name.replace(/[\[]/,"\\\[").replace(/[\]]/,"\\\]");
		    var regexS = "[\\?&]"+name+"=([^&#]*)";
		    var regex = new RegExp( regexS );
		    var results = regex.exec( url );
		    return results == null ? null : results[1];
		}
function categoryController($scope, $http, $location,$rootScope) {
    $scope.pageToGet = 0;

    $scope.state = 'busy';
    $scope.cartcount = 0;
    $scope.ids = "";
    $scope.lastAction = '';

    $scope.url = "category/";
    var applicationId = gup('a', $location.absUrl());

    $scope.record = {}
    
    $rootScope.contextpath = "http://linux.machine.com"
    $scope.url = $rootScope.contextpath+"/category-service/category/";
    $scope.files = [];
    
    $scope.slides = [];
    
    $scope.fileSelected = function (element) {
    	$scope.files = [];
        var myFileSelected = element.files[0];
        
        var dlgElem = angular.element("#editDlg");
	    if (dlgElem) {
	    	id = dlgElem.scope().data.id;
	    }
        
        //alert(id);
        var blob = myFileSelected.slice(0, -1, 'image/png'); 
        var newFile = new File([blob], id+'.jpeg', {type: 'image/jpeg'});
        $scope.files.push(newFile);
    };
    
    
    $scope.slideSelected = function (element,id) {
        var myFileSelected = element.files[0];
        var blob = myFileSelected.slice(0, -1, 'image/png'); 
        var newFile = new File([blob], id+'.jpeg', {type: 'image/jpeg'});
        $scope.slides.push(newFile);
    };

	  //listen for the file selected event
	  $scope.$on("fileSelected", function (event, args) {
		  
		  $scope.files = [];
	      $scope.$apply(function () {            
	          //add the file object to the scope's files collection
	          $scope.files.push(args.file);
	      });
	  });
	  
	  
	  
		

    $scope.getRecordList = function () {
    	
    	$scope.param = gup('a', $location.absUrl());
    	//alert('getting records for application '+ param);
    	console.log($scope.url);
        var url = $scope.url+'list/'+$scope.param+'/';
        //alert(url);
        //$scope.
        $scope.lastAction = 'list';

        $scope.startDialogAjaxRequest();
       
        var config = {params: {page: $scope.pageToGet}};

        $http.get(url, config)
            .success(function (data) {
            	
            	
            	//alert(JSON.stringify(data));
                $scope.finishAjaxCallOnSuccessData(data, null, false);
                
            })
            .error(function () {
            
                $scope.state = 'error';
            });
    }
    
    

    $scope.populateTable = function (data) {

            $scope.page = {source: data.baseCategory};
            $scope.tree = data.baseCategory.children; 
         
            $scope.tree = [{id: "0",name:"Flipkart", show:true,isSelected : false, children: data.baseCategory.children}];
//alert(data.baseCategory.children);
    }

     $scope.startDialogAjaxRequest = function () {
        $scope.displayValidationError = false;
       // $("#loadingModal").modal('show');
        
        var modalDialog = $("#loadingModal");
        modalDialog.css("margin-top", Math.max(0, ($(window).height() - modalDialog.height()) / 2));
        modalDialog.css("margin-left", Math.max(0, ($(window).width() - modalDialog.width()) / 2));
        modalDialog.modal('show');
        $scope.previousState = $scope.state;
        $scope.state = 'busy';
    }

    $scope.finishAjaxCallOnSuccessData = function (data, modalId, isPagination) {
        $scope.populateTable(data);
        $("#loadingModal").modal('hide');

        /*if(!isPagination){
            if(modalId){
                $scope.exit(modalId);
            }
        }
*/
        $scope.lastAction = '';
    }
    
    $scope.finishAjaxCallOnSuccess = function () {
       // $scope.populateTable(data);
        $("#loadingModal").modal('hide');

       
        $scope.lastAction = '';
    }
 
    $scope.delete = function(data,child) {
    	
    	
    	var dlgElem = angular.element("#confirm");
	    if (dlgElem) {
	    	//dlgElem.scope().deleteCategory = child.id;
	    	//dlgElem.scope().deleteCatName = child.name;
	    	dlgElem.scope().data = data;
	    	dlgElem.scope().child = child;
	    	
	    	 dlgElem.modal("show");
	    	
	    	 dlgElem.on("hide.bs.modal", function() {
   	          
  	    	   if($scope.yesButtonClick){
  	    		   $scope.yesButtonClick=false;
  	    		   
  	    		   $scope.deleteProduct(dlgElem.scope().child.id);
  	    		 dlgElem.scope().data.children.splice(dlgElem.scope().data.children.indexOf(child), 1);
  	    	   }
  	    	   
  	       });
	    }
    	
    	/*var cnt=0;
    	
    	$scope.deleteProduct(child.id);
    	data.children.splice(data.children.indexOf(child), 1);
    	*/
  
    };
    
    $scope.toggle = function(data) {
    var index;
    var bol=false;
    if(data.children[0].show==false)
                bol=true;
    for ( index = 0; index < data.children.length; ++index) {
    data.children[index].show = bol;
                                                } 
    };
    
    
   
    $scope.addButtonClick=false;
    $scope.yesButtonClick=false;

    $scope.modalButtonClick = function (modalDlg) {
    	
    	 var dlgElem = angular.element(modalDlg);
    	 $scope.addButtonClick=true;
         dlgElem.modal("hide");
         
      // console.log("do action on Modal");
     //  console.log("Current 'productId' value is [[" + dlgElem.scope().productId + "]]");
      
    };
    
    var counter=0;
    $scope.elements = [ {value : '', value : ''} ];

    $scope.newItem = function(data){
    	
        counter++;
       // alert (data.productSpecification);
        if(data.productSpecification == null)
        	data.productSpecification = [];
        	
        data.productSpecification.push(  { name:'',value:''} );
        
    }

    $scope.modalYesClick = function () {
    	
   	 var dlgElem = angular.element("#confirm");
   	 $scope.yesButtonClick=true;
        dlgElem.modal("hide");
        
   };
    
    
    $scope.add = function(data) {
    	
    	if(data.children==null) data.children=[];
        var post = data.children.length + 1;
        var newName = data.id + '-' + post;
    	
    	var dlgElem = angular.element("#addDlg");
    	    if (dlgElem) {
    	    	dlgElem.scope().productId = newName;
    	    	dlgElem.scope().productName = newName;
    	    	dlgElem.scope().data = data;
    	    	 dlgElem.modal("show");
    	       dlgElem.on("hide.bs.modal", function() {
    	          
    	    	   if($scope.addButtonClick){
    	    		   $scope.addButtonClick=false;
    	    		   $scope.productId = "";
    	    	       console.log("reset data model.."+dlgElem.scope().productId);
    	    	      
    	    	       var additionalattr = {};
    	    	       var addproduct = {id:dlgElem.scope().productId,	name:  dlgElem.scope().productName,
    	    	    	   parent:dlgElem.scope().data.id, order : data.children.length,
    	    	    	   someadditionalattr:{},breadcrumb : null,
    	    	    	   description:'',applicationId:$scope.param,
    	    	    	   show:true,isSelected : false,
    	    	    	   children: []};
    	    	       $scope.createProduct(addproduct);
    	    	       dlgElem.scope().data.children.push(addproduct);
    	    	   }
    	    	   
    	       });
    	    }
        
    };
    
    
    $scope.createProduct = function (addproduct) {
        

        $scope.lastAction = 'save';

        var url = $scope.url + 'save/';

        var config = {headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}};

        $scope.startDialogAjaxRequest();

        $http.post(url, $.param(addproduct), config)
            .success(function (data) {
                $scope.finishAjaxCallOnSuccess();
            })
            .error(function(data, status, headers, config) {
               // $scope.handleErrorInDialogs(status);
            	alert('error');
            });
    };
  
$scope.edit = function(parent,data) {
    	
	console.log("data.name.."+data.name);
	
	if(data.children!=null && data.children.length>0)
		var dlgElem = angular.element("#editCatDlg");
	else
    	var dlgElem = angular.element("#editDlg");
    	    if (dlgElem) {
    	    	dlgElem.scope().data = data;
    	    	
    	    	if(data.someadditionalattr==null)
    	    		data.someadditionalattr={};
    	    	 dlgElem.modal("show");
    	       dlgElem.on("hide.bs.modal", function() {
    	          
    	    	   if($scope.addButtonClick){
    	    		   $scope.addButtonClick=false;
    	    		   
    	    	       console.log("reset data model..");
    	    	      
    	    	       $scope.editProduct(dlgElem.scope().data);
    	    	     
    	    	   }
    	    	   
    	       });
    	    }
    	    
    	    
    };
   
$scope.editProduct = function (editproduct) {
        

        $scope.lastAction = 'edit';

        var url = $scope.url + 'edit/';

   

        $scope.startDialogAjaxRequest();
        
        var children = editproduct.children ;
      // console.log(angular.toJson(editproduct));
        editproduct.children = [];
        if(editproduct.someadditionalattr==null)
        	editproduct.someadditionalattr={};
       
        $http({
        	  method: 'POST',
        	  url: url,
        	 
        	  //data: { category: JSON.stringify(editproduct), files: $scope.files[0] }
        	 data: angular.toJson(editproduct) 
        	})
        	.then(function (success) {
        		//alert($scope.files[0] != undefined);
        		if($scope.files[0] != undefined){
        		$scope.doUploadFile();  
        		console.log('finish ajax')
        		}
        		$scope.finishAjaxCallOnSuccess();
        		
        	}, function (error) {
        		alert('error');
        	});
        
        
        
       
        editproduct.children = children;
    };
    
    $scope.doUploadFile = function(){
    	
        var file = $scope.files[0];
       
        var url = $scope.url + 'upload/';
        
        
        var data = new FormData();
        data.append('uploadfile', file);
        
        
     
        var config = {
     	   	transformRequest: angular.identity,
     	   	transformResponse: angular.identity,
 	   		headers : {
 	   			'Content-Type': undefined
 	   	    }
        }
        
        $http.post(url, data, config).then(function (response) {
        	$scope.finishAjaxCallOnSuccess();
        	var input = $("#control");
       	    input.replaceWith(input.val('').clone(true));
        	
 		}, function (response) {
 			
 		});
     };
    
     $scope.saveApp= function () {
     
    	 var url = $scope.url+ applicationId+'/upload/';
         //var url = 'http://localhost:8000/category/' + applicationId+'/upload/';
         var data = new FormData();
         data.append('uploadingFiles', $scope.slides[$scope.slides.length-3]);
         data.append('uploadingFiles', $scope.slides[$scope.slides.length-2]);
         data.append('uploadingFiles', $scope.slides[$scope.slides.length-1]);
      
         var config = {
      	   	transformRequest: angular.identity,
      	   	transformResponse: angular.identity,
  	   		headers : {
  	   			'Content-Type': undefined
  	   	    }
         }
         
         $http.post(url, data, config).then(function (response) {
         	$scope.finishAjaxCallOnSuccess();
         	var input = $("#control");
        	    input.replaceWith(input.val('').clone(true));
        	    $scope.addApplication();
        		alert('success');
        		
        		},function(data) {
        			alert(JSON.stringify(data))
        		});
  		}
	 $scope.addApplication= function () {   	 
		 var url = $rootScope.contextpath+'/application-service/application/save'
		 var config = {headers: {'Content-Type': 'application/json; charset=UTF-8'}};
		 var json = '{"id":"'+applicationId+'", "name" :"'+$scope.applicationname+'" }'
		 $http.post(url, json, config)
		 .then(function (data) {
			 //add remove
		 },function(data) {
 			alert(JSON.stringify(data))
 		});
	 }
    
 $scope.deleteProduct = function (id) {
        

        $scope.lastAction = 'delete';

        var url = $scope.url + 'delete/'+id+'/';

        
        var config = {params: {header: ''}};

       
        $scope.startDialogAjaxRequest();
        //alert(url);
        $http.get(url, config)
            .success(function (data) {
                $scope.finishAjaxCallOnSuccess();
            })
            .error(function(data, status, headers, config) {
               // $scope.handleErrorInDialogs(status);
            });
    };
    
	$scope.markSelected = function(data) {
        data.isSelected = true;
    };
	
    $scope.tree = [];// [{name: "Node",show:true,isSelected : false, nodes: []}];   
//    {"baseCategory":{"id":"base_","parent":"x","order":0,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[{"id":"Electronics","parent":"0","order":1,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[{"id":"Cameras_and_photograph","parent":"Electronics","order":1,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[{"id":"Digital_cameras","parent":"Cameras_and_photograph","order":1,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[],"description":null},{"id":"Camcoders","parent":"Cameras_and_photograph","order":2,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[],"description":null},{"id":"Lenses_and_Filters","parent":"Cameras_and_photograph","order":3,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[],"description":null},{"id":"Tripods_and_suppports","parent":"Cameras_and_photograph","order":4,"show":true,"someadditionalattr":null,"breadcrumb":null,"children":[],"description":null},{"id":"Lighting_and_Studio","pare
$scope.getRecordList();






}