<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	

<demo-grid :data="pageBean.currentPageItems" :columns="gridColumns"
	:filter-key="searchQuery"> </demo-grid>
<div v-if='pageBean.currentPageIndex'>
	<!-- 由于父组件异步获取数据，子组件第一次装载不能获取到父组件数据 -->

<page @refreshdatatable="getSearchPage"
		:initcurrent="pageBean.currentPageIndex"
		:initallpage="pageBean.totalPageCount"
		:inittotalitem="pageBean.totalItems"> </page>
		</div>