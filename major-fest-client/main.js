import React, { useEffect, useState } from 'react'
import { View, Text } from 'react-native'

function Main () {
  const [data, setData] = useState([])

  useEffect(() => {
    const apiUrl = 'http://localhost:8080/festivity'
    fetch(apiUrl)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .then(data => {
        setData(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error)
      })
  }, [])

  return (
    <View>
      {
        data.map((item) => {
          return <Text key={item._id}>Holla{item.name}</Text>
        })
      }
    </View>
  )
}

export default Main
