query{
  contact(id: 1) {
    id
    firstName
    lastName
    birthDate
    email
    phones {
      phoneType
      phoneNumber
    }
    address {
      street
      suburb
      state
      postCode
    }
    fullName
  }
}
