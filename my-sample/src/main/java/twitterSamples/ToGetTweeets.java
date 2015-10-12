package twitterSamples;

import java.util.*;

import twitter4j.*;

import twitter4j.conf.*;

public class ToGetTweeets {

	public static void main(String[] str) {

		ConfigurationBuilder cb = new ConfigurationBuilder();
//1
		cb.setOAuthConsumerKey("your oauth consumer key");
//2
		cb.setOAuthConsumerSecret("your oauth consumer secret key");
//3
		cb.setOAuthAccessToken("your oauth access token");
//4
		cb.setOAuthAccessTokenSecret("your oauth access secret token");

		Twitter twitter = new TwitterFactory(cb.build()).getInstance();

		int pageno = 1;

		String user = "@alonso_isidoro";

//		List statuses = new ArrayList();
		ResponseList<Status> myResponseList ;
		while (true) {

			try {

//				int size = statuses.size();

				Paging page = new Paging(pageno++, 100);

				myResponseList = twitter.getUserTimeline(user, page);

				
				//statuses.addAll(myResponseList);

				for (Status myStatus:myResponseList){
					System.out.println("UserId: " + myStatus.getUser());
					System.out.println("UserName: " + myStatus.getUser().getName());
					System.out.println("TweetText: " + myStatus.getText());
				}
//				if (statuses.size() == size) break;
//to get some twitts, 1000
//				ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1,1000));
//
//	            for (Status b: a){
//	                long userId = b.getUser().getId();// user Id
//	                String userName = b.getUser().getName(); // user name
//	                String tweetText = b.getText(); // tweet
//
//	                System.out.println(userId+" "+userName+" "+tweetText);
//	            }
	            
			}catch (TwitterException e) {

				e.printStackTrace();
			}

			
		}

//		System.out.println("Total: " + statuses.size());

	}
}