import SwiftUI
import shared

struct JokeView: View {
    var jokeResponse: JokeResponse
    
    init(jokeResponse: JokeResponse) {
        self.jokeResponse = jokeResponse
    }
    
    var body: some View {
        VStack {
            if (!self.jokeResponse.joke.isEmpty) {
                Text(jokeResponse.joke)
                    .multilineTextAlignment(.center)
            } else if (!jokeResponse.question.isEmpty && !jokeResponse.answer.isEmpty) {
                Text(jokeResponse.question)
                    .multilineTextAlignment(.center)
                Text(jokeResponse.answer)
                    .multilineTextAlignment(.center)
            }
        }
    }
}
