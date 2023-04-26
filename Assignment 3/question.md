<div id="not_right_side" class="ic-app-main-content">
        <div id="content-wrapper" class="ic-Layout-contentWrapper">
          
          <div id="content" class="ic-Layout-contentMain" role="main">
            
<style>
  #right-side-wrapper {
    height: 100%;
  }
</style>



<div id="assignment_show" class="assignment content_underline_links">
    <!--Student View-->
    <div class="assignment-title">
      <div class="title-content">
        <h1 class="title">
          Assignment 3
        <button aria-haspopup="dialog" class="ally-accessible-versions ally-add-tooltip" data-id="assignment:1760190" data-ally-content-id="assignment:1760190" data-ally-richcontent-eid="assignment:1760190" aria-label="Alternative formats" title="Alternative formats">
    <span class="ally-prominent-af-download-button"></span>
</button></h1>
      </div>
      <div class="assignment-buttons">
        

        
      </div>
    </div>
    
<ul class="student-assignment-overview">
  <li>
    <span class="title">Due</span>
    <span class="value">
          <span class="date_text">
                <span class="display_date">Feb 22</span> by 
                <span class="display_time">8:59pm</span>
          </span><!--
        --></span>
  </li>
  <li>
    <span class="title">Points</span>
    <span class="value">0</span>
  </li>
  
  <li>
    <span class="title">Available</span>
    <span class="value">
        after Feb 10 at 5:45pm
    </span>
  </li>

  <div class="clear"></div>
</ul>

  <div class="clear"></div>


  <div class="clear"></div>



  <div class="description user_content enhanced"><p>
 <a href="https://northeastern.instructure.com/courses/143020/files/19222812/download" data-id="19222812">
  Starter code
 </a>
</p>
<h3 id="1-introduction">
 1 Introduction
</h3>
<p>
 The "closest point query" is a popular problem in computational geometry: given a set P of points and a single query point Q, find (efficiently) the closest point to Q in P. Applications of this include finding the nearest cell phone tower for a given cell phone location, finding the nearest restaurant to your location on Google maps, etc. A related application is to find all points in P within a certain distance of Q. A popular technique to solving such problems efficiently is based on space partitioning: we divide the points in P by "regions" in a way that allows us to reject entire regions and only check a small subset of points. In this assignment you will implement a popular data structure that is based on space partitioning: a K-D tree.
</p>
<h3 id="11-binary-space-partitioning-and-k-d-tree">
 1.1 Binary Space Partitioning and K-D tree
</h3>
<p>
 Let us assume that our points are two-dimensional (i.e. they have an x and y coordinate). Imagine a rectangular region R that contains all the points in the dataset P that you wish to query. We draw a line L through R that divides it into two sub-regions R
 <sub>
  left
 </sub>
 and R
 <sub>
  right
 </sub>
 . This division of a space into two sub-spaces using a single line is an example of
 <em>
  binary
 </em>
 space partitioning. Each point in P is either in R
 <sub>
  left
 </sub>
 , or in R
 <sub>
  right
 </sub>
 , or on the dividing line L. We can represent this division as a binary tree: the root represents R, the left child represents R
 <sub>
  left
 </sub>
 and the right child represents R
 <sub>
  right
 </sub>
 . We call this a binary space partitioning (BSP) tree. In the special case where the dividing line is either vertical or horizontal, it becomes a (two-dimensional) K-D tree. The figure below illustrates a K-D tree for exactly 3 points (the point on the line is bolded):
</p>
<p>
 <img alt="Image not loaded" id="19222815" src="https://northeastern.instructure.com/courses/143020/files/19222815/download" data-id="19222815">
</p>
<p>
 We can continue the subdivision of R
 <sub>
  left
 </sub>
 and R
 <sub>
  right
 </sub>
 using different lines until each node has at most 1 (or a small, pre-defined number) of points. We can use several strategies to choose the dividing line. One strategy is to use the range to choose whether a line should be vertical or horizontal. If the x-range of the points (maximum x-coordinate - minimum x-coordinate) is greater than the y-range (maximum y-coordinate - minimum y-coordinate) then we choose a vertical line, otherwise a horizontal line. In the illustration below we alternate between horizontal and vertical dividing lines at each level (i.e. root uses a vertical line, its two children use horizontal lines, and so on). This K-D tree contains 100 points.
</p>
<p>
 <img alt="Image not loaded" id="19222814" src="https://northeastern.instructure.com/courses/143020/files/19222814/download" data-id="19222814">
</p>
<p>
 Although this assignment is limited to 2D, a K-D tree can have an arbitrary number of dimensions. For example a 3D K-D tree would store 3D points, and using dividing planes instead of lines.
</p>
<h3 id="12-k-d-tree-search">
 1.2 K-D tree search
</h3>
<p>
 We know of another binary tree data structure that supports efficient search: a binary search tree. What makes a binary search tree efficient?
</p>
<p>
 A binary search tree is able to search efficiently because it does not have to check all the data that it contains. Using the binary search property, its search algorithm chooses to go either left or right (effectively rejecting all the data that is in the subtree that it did not choose). The most efficient binary search trees are "balanced", i.e. at every node they have roughly the same number of data in its left and right subtrees. This allows them to reject up to half of the data at every level, producing a search algorithm that is logarithmic in time. The binary search algorithm on sorted arrays works on the same principle. How can we use this insight in a K-D tree?
</p>
<p>
 A K-D tree is characterized by a binary partitioning, and its dividing lines being horizontal or vertical. The placement of these lines is up to us. In order to "balance" a K-D tree rooted at a node, we can choose a horizontal or vertical line that divides the points in that nodes equally. This amounts to choosing the median of the X-coordinates (for a vertical line) or Y-coordinates (for a horizontal line) of the points. A simpler scheme is to simply alternate between horizontal and vertical lines as we go down the tree.
</p>
<h3 id="2-k-d-tree-algorithms">
 2 K-D tree algorithms
</h3>
<p>
 We now state the relevant algorithms in more precise manner.
</p>
<h3 id="22-distance-between-two-points">
 2.2 Distance between two points
</h3>
<p>
 We use the Euclidean distance between two points as our distance metric.
</p>
<h3 id="21-construction">
 2.1 Construction
</h3>
<p>
 Assume you are given a list of points P up-front. The construction algorithm is as follows:
</p>
<div class="codehilite" style="background: #f8f8f8">
 <pre style="line-height: 125%"><span></span><code>build-kdtree(P) {
    Px = indices that give P sorted by X-coordinates
    Py = indices that give P sorted by Y-coordinates
    //note that both lists above should be of the same size

    threshold = maximum number of points in a node //if more than this, subdivide

    recursive-build-kdtree(P,Px,Py,threshold,0)
}

recursive-build-kdtree(P,Px,Py,threshold,depth) {
    if (size of Px is less than or equal to threshold) {
        return leaf node with points in Px (or Py)
    }



    if (depth is even) { //use vertical line
        median = x-coordinate of the middle point in Px
        //line is ax+by+c
        a=1
        b=0
        c=-median
    }
    else {
        median = y-coordinate of the middle point in Py
        //line is ax+by+c
        a=0
        b=1
        c=-median
    }

    //divide points into before, after or on the line
    PxBefore: list of indices of all points before (negative signed distance) line, sorted by X-coordinates
    PxAfter:  list of indices of all points after (positive signed distance) line, sorted by X-coordinates
    On: list of indices of all points on the line
    PyBefore: list of indices of all points before (negative signed distance) line, sorted by Y-coordinates
    PyAfter:  list of indices of all points after (positive signed distance) line, sorted by Y-coordinates

    for (each index i in Px) {
      sd = signed-distance(P<span style="color: #008000; ">[i]</span>,a,b,c)
      if (sd&lt;0) {
        insert i in PxBefore
      }
      else if (sd&gt;0) {
        insert i in PxAfter
      }
      else {
        insert i in On
      }
    }

    //do the same for Py, but don't add points again to On

    left = recursive-build-kdtree(P,PxBefore,PyBefore,threshold,depth+1)
    right = recursive-build-kdtree(P,PxAfter,PyAfter,threshold,depth+1)
    return new-node(left,right,P,On,a,b,c) 
}

signed-distance(T,a,b,c) { //find the signed distance of point T from line ax+by+c=0
    return a*Tx+b*Ty+c
}
</code></pre>
</div>
<h3 id="22-find-all-points-within-a-circle">
 2.2 Find all points within a circle
</h3>
<p>
 This is a good query for a K-D tree, and is also a stepping stone for the nearest point query.
</p>
<div class="codehilite" style="background: #f8f8f8">
 <pre style="line-height: 125%"><span></span><code>all-points-within-circle(C,center,radius) { find all points within the specified circle in the tree rooted at C
    if (C is a leaf) {
        return all points in C that are inside or on circle
    }
    sd = signed-distance(center,a,b,c) //a,b,c from C
    if (dist&lt;=0) {
      list = find all points within circle in left child of C
      if (abs(sd)&lt;radius) {
        l = find all points within circle in right half of C
        add l to list
      }
    }
    else {
       list = find all points within circle in right half of C
      if (abs(sd)&lt;radius) {
        l = find all points within circle in left child of C
        add l to list
      }      
    } 
    add any points on line in C within the circle into list
    return list
}
</code></pre>
</div>
<h3 id="23-find-closest-point">
 2.3 Find closest point
</h3>
<p>
 The basic technique for this algorithm is to begin by traversing the K-D tree as if inserting the query point. When we reach a leaf, we find the closest point there. This creates a "circular window" centered at the query point, with a radius equal to the distance to the current closest point.
</p>
<p>
 However it is possible that there is a closer point "on the other side of a dividing line". Therefore the algorithm climbs the tree back along the same path. At each node, it determines if part of the current circular window crosses the dividing line, and if so, it recurs to the other side. It updates the radius of the circular window as it moves up the tree.
</p>
<p>
 Also, there may be cases where the leaf of a K-D tree is empty.
</p>
<div class="codehilite" style="background: #f8f8f8">
 <pre style="line-height: 125%"><span></span><code>closest-point(C,Q) { //find the point closest to Q in the tree rooted at C
    if (C is a leaf) {
        P = closest point in C
        return P
    }

    sd = signed-distance(Q,a,b,c) //dividing line of C
    if (sd&lt;0) { //go left
        center = Q   
        radius = infinity
        P = find closest point to Q in left child of C 
        if (P exists) {
            radius = distance(P,Q)
        }

        if (P does not exist, or abs(sd)&lt;=radius) { 
            PP = find closest point to Q on dividing line of C
            if (PP does not exist) {
                PP = find closest point to Q in right child of C
            }
            if (distance(PP,Q)&lt;radius) {
                P = PP
                radius = distance(P,Q)
            }
        }


        if (abs(sd)&lt;=radius) { //look to line and other side
            list = find all points in right child of C that are within circle with center "center" and radius "radius"
            PP = closest point to Q from list
            if (distance(P,Q)&gt;distance(Q,PP) { //update closest point
                P = PP
            }
        }

     }
     else { //go right
        counterpart case to above
     }
     return P
}
</code></pre>
</div>
<h3 id="3-what-to-do">
 3 What to do
</h3>
<p>
 You have been given a simple implementation of a helper class that represents a single 2D point.
</p>
<h3 id="31-interface">
 3.1 Interface
</h3>
<p>
 Write an interface called
 <code>
  SetOfPoints
 </code>
 that represents a set of 2D points, that can be searched. This interface should have the following methods:
</p>
<ul>
 <li>
  <p>
   A method
   <code>
    add
   </code>
   that takes a single
   <code>
    Point2D
   </code>
   object and adds this point to the set. The behavior of this method if the point already exists in the set, is dependent on the implementation
  </p>
 </li>
 <li>
  <p>
   A method
   <code>
    getPoints
   </code>
   that does not take any arguments, and returns a
   <code>
    List
   </code>
   of all the points currently in this set
  </p>
 </li>
 <li>
  <p>
   A method
   <code>
    allPointsWithinCircle
   </code>
   that takes the center of a circle (as a
   <code>
    Point2D
   </code>
   object) and a radius as a
   <code>
    double
   </code>
   and returns a
   <code>
    List
   </code>
   of all the points in this set that lie inside or on this circle
  </p>
 </li>
 <li>
  <p>
   A method
   <code>
    closestPoint
   </code>
   that takes a single query point
   <code>
    Point2D
   </code>
   and returns the point in this set that is closest to this query point. If no such point exists, this method should return
   <code>
    null
   </code>
  </p>
 </li>
</ul>
<h4 id="32-implementation">
 3.2 Implementation
</h4>
<p>
 Write a class called
 <code>
  PointKDTree
 </code>
 that implements the
 <code>
  SetOfPoints
 </code>
 interface. An object of this class will represent a 2D K-D tree of points, as described above. Your implementation should have the following characteristics:
</p>
<ul>
 <li>
  <p>
   This class should have a single constructor
   <code>
    PointKDTree(List&lt;Point2D&gt; points)
   </code>
   that builds a K-D tree that contains only these points.  The constructor should throw an
   <code>
    IllegalArgumentException
   </code>
   with an appropriate message if the list passed is null.
  </p>
 </li>
 <li>
  <p>
   This class should allow adding duplicate points (i.e. it may contain the same point more than once).
  </p>
 </li>
 <li>
  <p>
   This implementation should allow a leaf to contain at most 1 point.
  </p>
 </li>
 <li>
  <p>
   This class is not allowed to have any other public methods. It may have non-public helper methods.
  </p>
 </li>
 <li>
  <p>
   Your design must implement the K-D tree (specifically, its nodes) as a union type. You will have to adapt the above algorithms accordingly. You may choose to have a second implementation that has a different representation, if you'd like.
  </p>
 </li>
</ul>
<h4 id="33-tests">
 3.3 Tests
</h4>
<p>
 Write tests for your implementation. Read the test notes on the course web page to help you design tests effectively.
</p>
<h4 id="34-documentation">
 3.4 Documentation
</h4>
<p>
 We expect your code to be well-documented. The expectations are:
</p>
<ul>
 <li>
  <p>
   Each interface and class contains a comment above it explaining specifically what it represents. This should be in plain language, understandable by anybody wishing to use it. Comment above a class should be specific: it should not merely state that it is an implementation of a particular interface.
  </p>
 </li>
 <li>
  <p>
   Each public method in the interface should have information about what this method accomplishes (purpose), the nature and explanation of any arguments, return values and exceptions thrown by it and whether it changes the calling object in any way (contract).
  </p>
 </li>
 <li>
  <p>
   If a class implements a method declared in an interface that it implements,
   <strong>
    and
   </strong>
   the comments in the interface describe this implementation completely and accurately, there is no need to replicate that documentation in the class.
  </p>
 </li>
 <li>
  <p>
   All comments should be in Javadoc-style.
  </p>
 </li>
</ul>
<h3 id="4-grading-criteria">
 4 Grading criteria
</h3>
<ul>
 <li>
  <p>
   Correctness of the code
  </p>
 </li>
 <li>
  <p>
   Quality and coverage of tests (i.e. whether tests verify behavior in various situations)
  </p>
 </li>
 <li>
  <p>
   Design of classes, interfaces and methods
  </p>
 </li>
 <li>
  <p>
   Use of abstraction, wherever appropriate
  </p>
 </li>
 <li>
  <p>
   Quality of documentation
  </p>
 </li>
 <li>
  <p>
   Code style
  </p>
 </li>
</ul></div>


  <div style="display: none;">
    <span class="timestamp">1677117599</span>
    <span class="due_date_string">02/22/2023</span>
    <span class="due_time_string">08:59pm</span>
  </div>
</div>






  <div id="rubrics" class="mathjax_ignore" style="margin-bottom: 10px;">
    <div style="display: none;" id="rubric_parameters">
      <input type="hidden" name="rubric_association[association_type]" value="Assignment">
      <input type="hidden" name="rubric_association[association_id]" value="1760190">
      <input type="hidden" name="rubric_association[purpose]" value="grading">
    </div>
    
<div id="rubric_long_description_dialog" style="display: none;">
  <div class="editing">
    <form id="edit_criterion_form" class="no-margin-bottom">
      <div>
        <label class="rating_form_label">Description
          <textarea class="description" rows="1" name="description"></textarea>
        </label>
      </div>
      <div>
        <label class="rating_form_label">Long Description
          <textarea class="long_description" rows="4" name="long_description"></textarea>
        </label>
      </div>
      <div class="button-container">
        <button type="button" class="btn btn button-secondary cancel_button">Cancel</button>
        <button type="button" class="btn save_button btn-primary">Update Criterion</button>
      </div>
    </form>
  </div>
  <div class="displaying">
    <div class="long_description">
    </div>
  </div>
</div>
<div id="rubric_criterion_comments_dialog" style="display: none;">
  <div class="criterion_description" style="border-bottom: 1px solid #ccc; padding: 5px 0; font-size: 1.2em; font-weight: bold; margin-bottom: 5px;" tabindex="-1"></div>
  <div class="editing">
    <label for="criterion_comments_textarea">
      Additional Comments:
    </label>
    <textarea id="criterion_comments_textarea" class="criterion_comments" name="criterion_comments" style="width: 370px;"></textarea>
    <div class="button-container">
      <button type="button" class="btn btn button-secondary cancel_button">Cancel</button>
      <button type="button" class="btn save_button">Update Comments</button>
    </div>
  </div>
  <div class="displaying">
    Additional Comments:
    <div class="criterion_comments" style="margin-top: 10px;">
    </div>
  </div>
</div>
<div id="rubric_rating_dialog" style="display: none;">
  <div class="description" style="border-bottom: 1px solid #ccc; padding: 5px 0; font-size: 1.2em; font-weight: bold; margin-bottom: 5px;">
    <span id="edit_rating_form_criterion_description"></span>
  </div>
  <div class="editing">
    <form id="edit_rating_form" class="no-margin-bottom">
      <div class="toggle_for_hide_points">
        <div><label id="rating_form_score_label" class="rating_form_label">Rating Score</label></div>
        <span id="rating_form_max_score_label" hidden="">Rating max score</span>
        <input id="points" aria-labelledby="rating_form_score_label" type="text" size="2" name="points" class="no-margin-bottom span1">
        <span class="range_rating">to &gt;
          <input aria-label="Rating min score" type="text" size="2" name="min_points" class="no-margin-bottom span1 min_points" placeholder="min">
        </span>pts
      </div>
      <div>
        <label for="rating_form_title" class="rating_form_label">Rating Title</label>
        <input id="rating_form_title" type="text" class="rating_description" style="width: 90%;" name="description">
      </div>
      <div>
        <label for="rating_form_description" class="rating_form_label">Rating Description</label>
        <textarea id="rating_form_description" rows="4" style="width: 90%;" class="rating_long_description" name="rating_long_description" form="edit_rating_form"></textarea>
      </div>
      <div class="button-container">
        <button type="button" class="btn button-secondary cancel_button">Cancel</button>
        <button type="button" class="btn btn-primary save_button ok_button">Update Rating</button>
      </div>
    </form>
  </div>
</div>

  </div>
  
<div class="rubric_container rubric  " id="default_rubric" style="display: none;">
  <div class="screenreader-only"><h2>Rubric</h2></div>
  <div class="rubric_title">
    <div style="display: none;" class="links displaying pull-right">
      <a href="/courses/143020/rubrics/%7B%7B%20id%20%7D%7D" class=" edit_rubric_link no-print no-hover" style="" title="Edit Rubric" aria-label="Edit Rubric" role="button"><i class="icon-edit standalone-icon"></i></a>
      <a href="https://northeastern.instructure.com/search/rubrics?q=" class="find_rubric_link no-print no-hover" style="" title="Find Another Rubric" aria-label="Find Another Rubric" role="button"><i class="icon-search standalone-icon"></i></a>
        <a href="/courses/143020/rubric_associations/%7B%7B%20rubric_association_id%20%7D%7D" class="delete_rubric_link no-print no-hover" style="" title="Delete Rubric" aria-label="Delete Rubric" role="button"><i class="icon-trash standalone-icon"></i></a>
      <div style="display: none;">
        <div class="use_for_grading">&nbsp;</div>
        <div class="free_form_criterion_comments">&nbsp;</div>
        <div class="hide_score_total">&nbsp;</div>
        <div class="hide_outcome_results">&nbsp;</div>
        <div class="hide_points">&nbsp;</div>
        <div class="rubric_association_id">&nbsp;</div>
          <div class="user_id">&nbsp;</div>
        <div class="assessment_type"></div>
        <a href="/courses/143020/rubric_associations/%7B%7B%20rubric_association_id%20%7D%7D/assessments/%7B%7B%20assessment_id%20%7D%7D" rel="nofollow" class="edit_assessment_link">&nbsp;</a>
        <a href="/courses/143020/rubrics/%7B%7B%20rubric_id%20%7D%7D" class="edit_rubric_url">&nbsp;</a>
          <a href="/courses/143020/rubric_associations/%7B%7B%20association_id%20%7D%7D" class="delete_rubric_url">&nbsp;</a>
      </div>
    </div>
    <div style="float: right; font-size: 0.8em; display: none;" class="links displaying locked">
      <span style="">Can't change a rubric once you've started using it.</span>
        <a href="/courses/143020/rubric_associations/%7B%7B%20association_id%20%7D%7D" class="delete_rubric_url" style="display: none;">&nbsp;</a>
    </div>

    <div class="editing" style="float: right;">
      <a href="https://northeastern.instructure.com/search/rubrics?q=" class="find_rubric_link icon-search" style="" title="Find Existing Rubric">Find a Rubric</a>
    </div>
    <div class="editing" style="text-align: left">
      <label for="rubric-title">Title:</label>
      <input id="rubric-title" type="text" class="no-margin-bottom" name="title" value="Some Rubric" style="width: 200px;" maxlength="255" aria-label="Title:">
      <a href="https://northeastern.instructure.com/search/rubrics?q=" style="display: none;"><img alt="" src="https://du11hjcvx0uqb.cloudfront.net/dist/images/find-6164443e2a.png"> Find Rubric</a>
    </div>
    <div class="displaying">
      <span class="title" tabindex="-1">Title</span>
    </div>
    <div class="has-assessments-warning" style="display: none;">
      You've already rated students with this rubric. Any major changes could affect their assessment results.
    </div>
  </div>
<table class="rubric_table">
<caption>
  <div class="screenreader-only">
    <span class="title">Title</span>
  </div>
</caption>
<thead>
  <tr>
    <th scope="col">Criteria</th>
    <th scope="col">Ratings</th>
    <th scope="col" class="toggle_for_hide_points ">
      Pts
    </th>
  </tr>
</thead>
<tbody>
  
<tr id="criterion_blank" class="criterion blank" style="display: none;">
  <td class="criterion_description hover-container pad-box-micro">
    <div class="container">
      <div class="links editing">
          <a href="#" class="edit_criterion_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit criterion description</span></a>
        <a href="#" class="delete_criterion_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete criterion row</span></a>
      </div>
      <div class="description_content">
        <span class="outcome_sr_content" aria-hidden="true">
          <i class="learning_outcome_flag icon-outcomes" aria-hidden="true"></i>
          <span class="screenreader-only">This criterion is linked to a Learning Outcome</span>
        </span>
        <span class="description description_title">Description of criterion</span>
        <span class="learning_outcome_id" style="display: none;"></span>
        <span class="criterion_id" style="display: none;"></span>
          <div class="long_description small_description"></div>
        <div class="hide_when_learning_outcome ">
          <div class="criterion_use_range_div editing toggle_for_hide_points ">
            <label>Range
              <input type="checkbox" class="criterion_use_range"></label>
          </div>
        </div>
        <div class="threshold toggle_for_hide_points ">
          threshold:
          <span class="mastery_points">5</span> pts
        </div>
      </div>

    </div>
  </td>
  <td style="padding: 0;">
      <table class="ratings" style=""><tbody><tr>
          <td class="rating edge_rating
                
                ">
            <div class="container">
              <div class="rating-main">
                  <div class="editing links">
                    <a href="#" class="edit_rating_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit rating</span></a>
                    <a href="#" class="delete_rating_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete rating</span></a>
                  </div>
                  <div class="clear"></div>
                <span class="nobr toggle_for_hide_points ">
                  <span class="points">5</span>
                  <span class="range_rating" style="display: none;">to &gt;<span class="min_points">0</span></span> pts
                </span>
                <div class="description rating_description_value">Full Marks</div>
                <div class="rating_long_description small_description"></div>
                <span class="rating_id" style="display: none;">blank</span>
              </div>
                <div class="editing links add_rating_link">
                  <a href="#" class="add_rating_link_after" aria-label="Add rating"><i class="icon-add icon-Solid"></i></a>
                </div>
            </div>
          </td>
          <td class="rating edge_rating
                infinitesimal
                ">
            <div class="container">
              <div class="rating-main">
                  <div class="editing links">
                    <a href="#" class="edit_rating_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit rating</span></a>
                    <a href="#" class="delete_rating_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete rating</span></a>
                  </div>
                  <div class="clear"></div>
                <span class="nobr toggle_for_hide_points ">
                  <span class="points">0</span>
                  <span class="range_rating" style="display: none;">to &gt;<span class="min_points">0</span></span> pts
                </span>
                <div class="description rating_description_value">No Marks</div>
                <div class="rating_long_description small_description"></div>
                <span class="rating_id" style="display: none;">blank_2</span>
              </div>
            </div>
          </td>
      </tr></tbody></table>
      <div style="display: none; font-size: 0.8em; margin: 5px;" class="custom_ratings">
        This area will be used by the assessor to leave comments related to this criterion.
      </div>
  </td>
  <td class="nobr points_form toggle_for_hide_points ">
    <div class="editing" style="white-space: normal">
      <span style="white-space: nowrap; font-size: 0.8em">
          
            <input type="text" aria-label="Points" value="5" class="criterion_points span1 no-margin-bottom">
           pts
      </span><br>
    </div>
    <div class="displaying">
      <span style="white-space: nowrap;">
        <span class="criterion_rating_points_holder" style="display: none;">
          <span class="criterion_rating_points">&nbsp;</span> /
        </span>
        <span class="display_criterion_points">5</span> pts<br>
      </span>
    </div>
    <div class="ignoring">
      <span> -- </span>
    </div>
    <div class="criterion_comments">
        <a href="#" class="no-hover criterion_comments_link" title="Additional Comments">
          <img alt="Additional Comments" src="https://du11hjcvx0uqb.cloudfront.net/dist/images/rubric_comment-ddae8546ab.png">
        </a>
        <div class="custom_rating" style="display: none;"></div>
    </div>
  </td>
</tr>

  <tr id="criterion_1" class="criterion" style="display: table-row;">
  <td class="criterion_description hover-container pad-box-micro">
    <div class="container">
      <div class="links editing">
          <a href="#" class="edit_criterion_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit criterion description</span></a>
        <a href="#" class="delete_criterion_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete criterion row</span></a>
      </div>
      <div class="description_content">
        <span class="outcome_sr_content" aria-hidden="true">
          <i class="learning_outcome_flag icon-outcomes" aria-hidden="true"></i>
          <span class="screenreader-only">This criterion is linked to a Learning Outcome</span>
        </span>
        <span class="description description_title">Description of criterion</span>
        <span class="learning_outcome_id" style="display: none;"></span>
        <span class="criterion_id" style="display: none;"></span>
          <div class="long_description small_description"></div>
        <div class="hide_when_learning_outcome ">
          <div class="criterion_use_range_div editing toggle_for_hide_points ">
            <label>Range
              <input type="checkbox" class="criterion_use_range"></label>
          </div>
        </div>
        <div class="threshold toggle_for_hide_points ">
          threshold:
          <span class="mastery_points">5</span> pts
        </div>
      </div>

    </div>
  </td>
  <td style="padding: 0;">
      <table class="ratings" style=""><tbody><tr>
          <td class="rating edge_rating
                
                ">
            <div class="container">
              <div class="rating-main">
                  <div class="editing links">
                    <a href="#" class="edit_rating_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit rating</span></a>
                    <a href="#" class="delete_rating_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete rating</span></a>
                  </div>
                  <div class="clear"></div>
                <span class="nobr toggle_for_hide_points ">
                  <span class="points">5</span>
                  <span class="range_rating" style="display: none;">to &gt;<span class="min_points">0</span></span> pts
                </span>
                <div class="description rating_description_value">Full Marks</div>
                <div class="rating_long_description small_description"></div>
                <span class="rating_id" style="display: none;">blank</span>
              </div>
                <div class="editing links add_rating_link">
                  <a href="#" class="add_rating_link_after" aria-label="Add rating"><i class="icon-add icon-Solid"></i></a>
                </div>
            </div>
          </td>
          <td class="rating edge_rating
                infinitesimal
                ">
            <div class="container">
              <div class="rating-main">
                  <div class="editing links">
                    <a href="#" class="edit_rating_link"><i class="icon-edit standalone-icon"></i><span class="screenreader-only">Edit rating</span></a>
                    <a href="#" class="delete_rating_link"><i class="icon-trash standalone-icon"></i><span class="screenreader-only">Delete rating</span></a>
                  </div>
                  <div class="clear"></div>
                <span class="nobr toggle_for_hide_points ">
                  <span class="points">0</span>
                  <span class="range_rating" style="display: none;">to &gt;<span class="min_points">0</span></span> pts
                </span>
                <div class="description rating_description_value">No Marks</div>
                <div class="rating_long_description small_description"></div>
                <span class="rating_id" style="display: none;">blank_2</span>
              </div>
            </div>
          </td>
      </tr></tbody></table>
      <div style="display: none; font-size: 0.8em; margin: 5px;" class="custom_ratings">
        This area will be used by the assessor to leave comments related to this criterion.
      </div>
  </td>
  <td class="nobr points_form toggle_for_hide_points ">
    <div class="editing" style="white-space: normal">
      <span style="white-space: nowrap; font-size: 0.8em">
          
            <input type="text" aria-label="Points" value="5" class="criterion_points span1 no-margin-bottom">
           pts
      </span><br>
    </div>
    <div class="displaying">
      <span style="white-space: nowrap;">
        <span class="criterion_rating_points_holder" style="display: none;">
          <span class="criterion_rating_points">&nbsp;</span> /
        </span>
        <span class="display_criterion_points">5</span> pts<br>
      </span>
    </div>
    <div class="ignoring">
      <span> -- </span>
    </div>
    <div class="criterion_comments">
        <a href="#" class="no-hover criterion_comments_link" title="Additional Comments">
          <img alt="Additional Comments" src="https://du11hjcvx0uqb.cloudfront.net/dist/images/rubric_comment-ddae8546ab.png">
        </a>
        <div class="custom_rating" style="display: none;"></div>
    </div>
  </td>
</tr><tr class="summary">
    <td colspan="4">
      <div class="total_points_holder toggle_for_hide_points " style="float: right; ">
        <span>Total Points:
            <span class="rubric_total">
              5
            </span>
 <span class="assessing">out of 5</span>        </span>
      </div>
      <div class="editing pull-left">
        <span id="add_criterion_holder" class="criterion_link"></span>
      </div>
      <div class="clear"></div>
    </td>
  </tr>
</tbody>
</table>
</div>
<table style="display: none;">
  <tbody><tr id="edit_rubric">
    <td colspan="4">
      <form id="edit_rubric_form" class="edit-rubric-form no-margin-bottom">
        <div class="rubric_custom_ratings" style="">
          <input type="checkbox" id="rubric_custom_rating" class="rubric_custom_rating">
          <label for="rubric_custom_rating">I'll write free-form comments when assessing students</label>
        </div>
          <div class="hide_points" style="">
            <input type="checkbox" id="hide_points" class="hide_points_checkbox">
            <label for="hide_points">Remove points from rubric</label>
          </div>
          <div class="hide_outcome_results" style="">
            <input type="checkbox" id="hide_outcome_results" class="hide_outcome_results_checkbox">
            <label for="hide_outcome_results">Don't post Outcomes results to Learning Mastery Gradebook</label>
          </div>
          <div class="rubric_grading" style="">
            <input type="checkbox" id="grading_rubric" class="grading_rubric_checkbox">
            <label for="grading_rubric">Use this rubric for assignment grading</label>
          </div>
        <div class="totalling_rubric" style="">
          <input type="checkbox" id="totalling_rubric" class="totalling_rubric_checkbox">
          <label for="totalling_rubric">Hide score total for assessment results</label>
        </div>
        <div class="ic-Action-header ic-Action-header--half-margin">
          <div class="ic-Action-header__Primary">
            <button type="button" class="Button cancel_button">Cancel</button>
            <button type="submit" class="Button Button--primary save_button">Create Rubric</button>
          </div>
        </div>
      </form>
    </td>
  </tr>
</tbody></table>


  <div id="assignment_external_tools"><div></div></div>

  


          </div>
        </div>
        <div id="right-side-wrapper" class="ic-app-main-content__secondary">
          <aside id="right-side" role="complementary">
            
<div id="sidebar_content">


</div>

          </aside>
        </div>
      </div>