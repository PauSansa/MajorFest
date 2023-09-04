import { SafeAreaView, StyleSheet } from 'react-native'
import React, { useEffect, useState } from 'react'
import Home from './src/screens/Home'
import axios from 'axios'

const FESTIVITY_API_URL = 'http://localhost:8080/festivity'

export default function App () {
  const [data, setData] = useState([])

  useEffect(() => {
    axios.get(FESTIVITY_API_URL)
      .then(response => setData(response.data))
      .catch(error => console.error(error))
  }, [])

  return (
    <SafeAreaView style={styles.root}>
      <Home data={data}/>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: '#F9FBFC'
  }
})
