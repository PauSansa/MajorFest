import React from 'react'
import { Text, View, StyleSheet, ImageBackground, TouchableOpacity } from 'react-native'

function FestivityCard ({ event, onPress }) {
  return (
    <TouchableOpacity onPress={onPress}>
      <ImageBackground
        source={{
          uri:
            event.image
        }}
        style={styles.container}
        imageStyle={styles.image}
      >
        <View style={styles.overlay} />
        <Text style={styles.title}>{event.name}</Text>
        <Text style={styles.location}>{event.location}</Text>
      </ImageBackground>
    </TouchableOpacity>
  )
}

const styles = StyleSheet.create({
  container: {
    flexDirection: 'column',
    borderRadius: 20,
    padding: 35,
    margin: 12,
    shadowColor: '#000',
    shadowOffset: {
      width: 0,
      height: 2
    },
    shadowOpacity: 0.25,
    shadowRadius: 3.84,
    elevation: 5,
    overflow: 'hidden'
  },
  image: {
    resizeMode: 'cover'
  },
  overlay: {
    ...StyleSheet.absoluteFillObject, // Fill the entire container
    backgroundColor: 'rgba(0, 0, 0, 0.6)', // Semi-transparent black color
    borderRadius: 20
  },
  title: {
    color: 'white',
    fontSize: 20,
    fontWeight: 'bold',
    zIndex: 1 // Ensure text appears above the overlay
  },
  location: {
    color: 'whitesmoke'
  }
})

export default FestivityCard
