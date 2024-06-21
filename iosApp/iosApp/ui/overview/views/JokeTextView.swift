import SwiftUI
import shared


struct JokeTextView: View {
    var joke: Joke
    
    init(joke: Joke) {
        self.joke = joke
    }
    
    var body: some View {
        VStack {
            if (!self.joke.jokeText.isEmpty) {
                Text(joke.jokeText)
                    .multilineTextAlignment(.center)
            } else if (!joke.question.isEmpty && !joke.answer.isEmpty) {
                Text(joke.question)
                    .multilineTextAlignment(.center)
                Text(joke.answer)
                    .multilineTextAlignment(.center)
            }
        }
    }
}
