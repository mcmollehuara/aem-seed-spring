<%@include file="/libs/foundation/global.jsp"%>
<%@taglib prefix="neba" uri="http://neba.io/1.0"%>
<neba:defineObjects />
<script type="text/html" id="scheduleTemplate">
  <tr>
      <td data-content="time"></td>
      <td data-content="title"></td>
      <td data-content="speakers"></td>
    </tr>
</script>
<div>

<h2>${properties.title}</h2>
<h3 class="conferenceDate"></h3>
<table class="table table-striped" id="adaptToTalks">
  <thead>
    <tr>
      <th>
         <span class="sortable asc" data-sort="start_time" data-sortdir="asc">
            ${properties.headerTime}
            <span class="icon-sort"></span>
            <span class="icon-sort-up"></span>
            <span class="icon-sort-down"></span>
         </span>
      </th>
      <th>
         <span class="sortable none" data-sort="topic" data-sortdir="none">
             ${properties.headerTalk}
             <span class="icon-sort"></span>
             <span class="icon-sort-up"></span>
             <span class="icon-sort-down"></span>
         </span>
      </th>
      <th>
         <span class="sortable none" data-sort="speakers" data-sortdir="none">
          ${properties.headerSpeakers}
           <span class="icon-sort"></span>
           <span class="icon-sort-up"></span>
           <span class="icon-sort-down"></span>
         </span>
      </th>
    </tr>
  </thead>
  <tbody>
  </tbody>
</table>
<cq:include resourceType="spademo/components/pager" path="pager" />
</div>
<!-- <script type="text/javascript">
    aemspa.scheduletable.init({
      getPageContentUrl: '/bin/mvc.do/scheduletable/getresult',
      sortDataUrl: '/bin/mvc.do/scheduletable/sortresult'
    });
</script> -->