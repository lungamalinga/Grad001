# GRAD001 - LUNGAMALINGA - ASSESSMENT PROJECT

# URL
> URL : http://localhost:8080

# END POINTS: 

[//]: # (tips)
# GET ALL RECYCLING TIPS [GET REQUEST]
> _**/tips/all**_

# GET ONE Tip by ID [tip id is an integer]
> _**tips/{tip_id}**_

# SAVE/CREATE NEW TIP [POST REQUEST]
> _**/tips/save/tip**_
>   <br> request body [example]:  
    _{ "category_id": 12, "tip_description": "Dont litter on the floor - PLEASE!!!" }_

# DELETE TIP [POST REQUEST]
> **_/tips/delete/tip_**
<br> body example: _{ "tip_id": 9 }_

# UPDATE A TIP RECORD
> **_tips/update/tip_**
<br> body example: {"tip_id": 2,"category_id": 44,"tip_description": "my name is lunga malinga"}

[//]: # (disposal guidelines)
# GET ALL DISPOSAL GUIDELINES
> **_/disposalguidelines_**

# GET ONE DISPOSAL GUIDELINES BY ID [id is an integer]
> /disposalguidelines/{id}










