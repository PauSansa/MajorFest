import React from 'react'
import { SafeAreaView, Text, StyleSheet, Image, View } from 'react-native' // Added ScrollView
import data from '../../../data.json'
function Festivity () {
  return (
    <SafeAreaView style={styles.root}>
      <Text style={styles.title}>{data.name}</Text>
      <Text style={styles.subtitle}>{data.description}</Text>
      <Image style={styles.image} source={{ uri: data.image }} />

      <View style={styles.dates}>
        <Text style={styles.subtitle}>Dates: {data.date[0]}</Text>
      </View>

      <View style={styles.details}>

        <View style={styles.detail}>
          {data.concerts.map(concert => (
            <View key={concert.name} style={styles.detailItem}>
              <Text>{concert.name}</Text>
            </View>
          ))}
        </View>

        <View style={styles.detail}>
          {data.barItems.map(barItem => (
            <View key={barItem.name} style={styles.detailItem}>
              <Text>{barItem.name}</Text>
              <Text>{barItem.value}</Text>
            </View>
          ))}
        </View>

      </View>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: '#F9FBFC',
    alignItems: 'center',
    gap: 10
  },
  title: {
    fontSize: 30,
    fontWeight: 'bold',
    marginTop: 20
  },
  subtitle: {
    fontSize: 20,
    fontWeight: 'normal',
    marginTop: 10
  },
  image: {
    width: 400,
    height: 200,
    marginTop: 20,
    borderRadius: 30
  },
  dates: {
    flexDirection: 'row',
    backgroundColor: 'rgba(34,34,34,0.3)',
    borderRadius: 12,
    width: '80%'
  },
  details: {
    marginTop: 20,
    width: 400,
    flexDirection: 'row',
    gap: 10
  },
  detail: {
    flexDirection: 'column',
    gap: 10,
    flex: 1,
    justifyContent: 'space-evenly',
    alignItems: 'center'
  },
  detailItem: {
    flexDirection: 'row', // Changed to row to align items horizontally
    justifyContent: 'space-between', // Added to create space between items
    paddingVertical: 10, // Added to create spacing around items
    backgroundColor: 'rgba(128, 0, 128, 0.3)',
    borderRadius: 12,
    paddingHorizontal: 10,
    gap: 10
  }
})

export default Festivity
