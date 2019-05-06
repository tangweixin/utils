#! /bin/bash
# desc: 发布到中央仓库

echo "切换到当前目录"
cd "$(dirname "$0")"


mvn -s ~/.m2/settings.sonatype.xml clean deploy verify  -Dgpg.passphrase=hDKFUo6b

echo "完成"