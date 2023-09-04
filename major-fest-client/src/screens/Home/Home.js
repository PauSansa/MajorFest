import { ScrollView, View, StyleSheet, Text } from 'react-native'
import FestivityCard from '../../components/FestivityCard'
import React from 'react'

function Home ({ data }) {
  const prueba = () => {
    alert('Fiesta: ' + data.name)
  }

  const styles = StyleSheet.create({
    title: {
      fontWeight: 'bold',
      fontSize: 20,
      padding: 20
    }

  })

  return (
    <ScrollView>
        <Text style={styles.title}>Proximas Festes Majors</Text>
      {data.map(item => (
        <View key={item.uuid}>
          <FestivityCard event={item} onPress={prueba}></FestivityCard>
        </View>
      ))}
    </ScrollView>
  )
}

export default Home
