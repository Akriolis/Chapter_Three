
class User (val id: Int, val name: String, val address: String) {

    fun saveUser(user: User){
        if (user.name.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name"
            )
        }

        if (user.address.isEmpty()){
            throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address"
            )
        }

    }

    // more concise way is put validation into saveUser2 function (which is upgrade of saveUser fun)

    fun saveUser2 (user: User){
        fun validate (user: User,
                      value: String,
                      fieldName: String){
            if (value.isEmpty()){
                throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName"
                )
            }
        }
        validate(user, user.name, "Name")
        validate(user, user.address, "Address")

    }

    fun saveUser3 (user: User){
        fun validate (value: String, fieldName: String){
            if (value.isEmpty()){
                throw IllegalArgumentException(
                    "Can't save user ${user.id}:" +
                            "empty $fieldName")
            }
        }

        validate(user.name, "Name")
        validate(user.address, "Address")

    }

    fun saveUser4(user: User){
        user.validateBeforeSave()
    }

    private fun User.validateBeforeSave(){
        fun validate(value: String, fieldName: String){
            if (value.isEmpty()){
                throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName"
                )
            }
        }
        validate(name, "Name")
        validate(address, "Address")
    }


}