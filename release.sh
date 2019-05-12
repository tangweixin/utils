#! /bin/bash
# desc: 发布到中央仓库

echo "切换到当前目录"
cd "$(dirname "$0")"

#签名失败
#gpg --list-secret-keys
#gpg --keyserver keyserver.ubuntu.com --send-keys 7D6B64B07C0075B5

mvn -s ~/.m2/settings.sonatype.xml clean deploy verify
#-Dgpg.passphrase=hDKFUo6b

echo "完成"