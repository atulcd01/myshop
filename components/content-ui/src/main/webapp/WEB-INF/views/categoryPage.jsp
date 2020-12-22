<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<style>
ul, li {list-style-type: none;}
.font-bold {
  font-weight: bold;
}

</style>
<div class="row-fluid" ng-controller="categoryController" >

<form>
            <div class="form-group">
          
            <label for="productId">Application Id</label>
            {{applicationid}}<br>
               <label for="appName">Application Name</label>
               <input type="text" class="form-control" ng-model="applicationname" 
                placeholder="appName">
                
                <label for="control1">Upload Slid 1 Image</label>
                <input type="file" id="control1" onchange = "angular.element(this).scope().slideSelected(this,'slideone')" />
                
                <label for="control2">Upload Slid 1 Image</label>
                <input type="file" id="control2" onchange = "angular.element(this).scope().slideSelected(this,'slidetwo')" />
                
                <label for="control3">Upload Slid 1 Image</label>
                <input type="file" id="control3" onchange = "angular.element(this).scope().slideSelected(this,'slidethree')" />
                
                
                
            </div>
            <button class="btn btn-default" 

            ng-click="saveApp()">Save Details</button>
         </form>


	<script type="text/ng-template" id="tree_item_renderer.html">

	<a href="" class="text-left" >{{children.name}}</a>

	

	<button  ng-click="add(children)" class="text-right align-top">Add</button>
	<button  ng-click="edit(model,children)" class="text-right align-top">Edit</button>
    <button  ng-click="delete(model,children)" class="text-right align-top" ng-show="children.children==null  || children.children.length == 0" >Delete</button>
    <button  ng-click="toggle(children)" class="text-right align-top" ng-show="children.children.length > 0" >Toggle</button>    
<div>&nbsp;</div>
<p ng-bind-html="children.breadcrumb"></p>

	
	<div >
<Panel>
    <ul >
        <li class="list-group-item" ng-init="model = $parent.children"  ng-repeat="children in children.children" ng-include="'tree_item_renderer.html'" ng-show="children.show"  ></li>
			
    </ul>
</Panel>
	</div>
</script>

<ul class="list-group list-group-flush">

    <li class="list-group-item" ng-repeat="children in tree" ng-include="'tree_item_renderer.html'" md-parent-scope="this" ng-init="model = tree"></li>

</ul>

 <div class="row">
            
         
         <ng-include src="'http://linux.machine.com/content-service/resources/templates/addModal.html'"></ng-include>
          <ng-include src="'http://linux.machine.com/content-service/resources/templates/editModal.html'"></ng-include>
          <ng-include src="'http://linux.machine.com/content-service/resources/templates/editCategoryModal.html'"></ng-include>
         <ng-include src="'http://linux.machine.com/content-service/resources/templates/confirm.html'"></ng-include>
         <ng-include src="'http://linux.machine.com/content-service/resources/templates/loadingModal.html'"></ng-include>
         
         
      </div>



</div></html>



<script src="<c:url value="http://linux.machine.com/content-service/resources/js/pages/category.js" />"></script>